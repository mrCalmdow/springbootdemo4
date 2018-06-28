package com.flchen.demo4.controller;

import com.flchen.demo4.common.annotation.LocalLock;
import com.flchen.demo4.entity.User;
import com.flchen.demo4.validation.Groups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author feilongchen
 * @create 2018-06-26 10:05 AM
 */
@RestController
@RequestMapping("/caches")
public class CacheController {

	private static final Logger log = LoggerFactory.getLogger(CacheController.class);
	List<User> users = new ArrayList<>();

	@PostMapping
	@LocalLock(key = "user:arg[0]")
	public List<User> testDuplicateInsert(@RequestBody @Validated(value = {Groups.Default.class}) User user) {
		users.add(user);
		return users;
	}
}
