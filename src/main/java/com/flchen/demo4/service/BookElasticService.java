//package com.flchen.demo4.service;
//
//import com.flchen.demo4.entity.Book;
//import com.flchen.demo4.repositories.BookRepository;
//import org.elasticsearch.client.Client;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @author feilongchen
// * @create 2018-06-27 1:52 PM
// */
//@Service
//public class BookElasticService {
//
//	private static final Logger log = LoggerFactory.getLogger(BookElasticService.class);
//
//	@Autowired
//	private ElasticsearchOperations es;
//
//	@Autowired
//	private BookRepository bookRepository;
//
//	public List<Book> findByName(String name){
//		return bookRepository.findByName(name);
//	}
//
//	public Iterable<Book> findAll() {
//		return bookRepository.findAll();
//	}
//
//	public Book save(Book book) {
//		return bookRepository.save(book);
//	}
//
//	public void deleter(Book book) {
//		bookRepository.delete(book);
//	}
//
//	public Map<String, String> printElasticSearchInfo() {
//
//		System.out.println("--ElasticSearch-->");
//		Client client = es.getClient();
//		Map<String, String> asMap = client.settings().getAsMap();
//		asMap.forEach((k, v) -> {
//			System.out.println(k + " = " + v);
//		});
//		System.out.println("<--ElasticSearch--");
//		return asMap;
//	}
//}
