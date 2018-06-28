package com.flchen.demo4.controller;

import com.flchen.autoconfigdemo.AuthorServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author feilongchen
 * @create 2018-06-28 9:27 AM
 */
@RestController
@RequestMapping("/autoConfiguration")
public class AutoConfigurationDemoController {

	private static final Logger log = LoggerFactory.getLogger(AutoConfigurationDemoController.class);

	@Autowired
	private AuthorServer authorServer;

	@GetMapping
	public String getAuthorInfo() {
		return authorServer.getAuthor();
	}
}
