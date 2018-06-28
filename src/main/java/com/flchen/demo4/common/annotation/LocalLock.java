package com.flchen.demo4.common.annotation;

import java.lang.annotation.*;

/**
 * @author feilongchen
 * @create 2018-06-25 7:19 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {

	String key() default "";

	int expire() default 5;
}
