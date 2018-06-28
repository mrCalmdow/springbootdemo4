package com.flchen.demo4.common.aop;

import com.flchen.demo4.common.CustomeException;
import com.flchen.demo4.common.annotation.LocalLock;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author feilongchen
 * @create 2018-06-25 7:24 PM
 */
@Aspect
@Configuration
@EnableAspectJAutoProxy
public class LockMethodInterceptor {

	private static final Logger log = LoggerFactory.getLogger(LockMethodInterceptor.class);

	private static final Cache<String, Object> CACHES = CacheBuilder.newBuilder()
			//设置最大缓存数1000
			.maximumSize(1000)
			//设置写缓存后5秒过期
			.expireAfterAccess(5, TimeUnit.SECONDS).build();

	@Around("execution(public * * (..)) && @annotation(com.flchen.demo4.common.annotation.LocalLock)")
	public Object interceptor(ProceedingJoinPoint pjp) {

		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		LocalLock localLock = method.getAnnotation(LocalLock.class);
		String key = combineKey(localLock.key(), pjp.getArgs());

		if(!StringUtils.isEmpty(key)) {
			//已经存在缓存中
			if(CACHES.getIfPresent(key) != null) {
				log.error("Duplicate commit");
				throw new CustomeException(400, "Duplicate commit");
			}

			//加入到缓存中
			CACHES.put(key, key);
		}

		try {
			return pjp.proceed();
		} catch (Throwable throwable) {
			log.error("Internal error");
			throw new RuntimeException();
		} finally {
//			CACHES.invalidate(key);
		}
	}

	/**
	 * 根据annotation里面的key来拼装缓存key值，使其具有唯一性
	 * @param keyExpress
	 * @param args
	 * @return
	 */
	private String combineKey(String keyExpress, Object[] args) {

		for(int i = 0; i < args.length; i++) {
			keyExpress = keyExpress.replace("arg[" + i + "]", args[i].toString());
		}
		return keyExpress;
	}
}
