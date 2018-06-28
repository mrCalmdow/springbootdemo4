package com.flchen.demo4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author feilongchen
 * @create 2018-06-25 5:17 PM
 */
@RestController
@RequestMapping("/testException")
public class TestExceptionController {

	private static final Logger log = LoggerFactory.getLogger(TestExceptionController.class);

	@RequestMapping("/test")
	public String test(@RequestParam("num") int num) {
		int i = 10 / num;
		return "result " + i;
	}
}
