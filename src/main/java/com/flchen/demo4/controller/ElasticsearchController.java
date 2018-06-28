//package com.flchen.demo4.controller;
//
//import com.flchen.demo4.entity.Book;
//import com.flchen.demo4.service.BookElasticService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @author feilongchen
// * @create 2018-06-27 2:53 PM
// */
//@RestController
//@RequestMapping("/books")
//public class ElasticsearchController {
//
//	private static final Logger log = LoggerFactory.getLogger(ElasticsearchController.class);
//
//	@Autowired
//	private BookElasticService bookElasticService;
//
//	@RequestMapping("/findByName/{name}")
//	public List<Book> searchByBookName(@PathVariable String name) {
//		return bookElasticService.findByName(name);
//	}
//
//	@PostMapping
//	public Book insertBook(@RequestBody @Validated Book book) {
//		return bookElasticService.save(book);
//	}
//
//	@GetMapping("/info")
//	public Map<String, String> getInfo() {
//		return bookElasticService.printElasticSearchInfo();
//	}
//
//}
