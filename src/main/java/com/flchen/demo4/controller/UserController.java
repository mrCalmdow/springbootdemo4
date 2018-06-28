package com.flchen.demo4.controller;

import com.flchen.demo4.common.annotation.LocalLock;
import com.flchen.demo4.entity.User;
import com.flchen.demo4.validation.Groups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * @author feilongchen
 * @create 2018-06-25 6:45 PM
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	private List<User> users = new ArrayList();

	@PostMapping
	@LocalLock(key = "u:arg[0]")
	public User insert(@RequestBody @Validated(value = Groups.Default.class) User user) {
		user.setId(new Long(users.size()));
		users.add(user);
		return user;
	}

	@PutMapping
	public User update(@RequestBody @Validated(value = Groups.Update.class) User user) {
		User u = users.get(user.getId().intValue());
		u.setAge(user.getAge());
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		users.set(user.getId().intValue(), u);

		return users.get(user.getId().intValue());
	}
}
