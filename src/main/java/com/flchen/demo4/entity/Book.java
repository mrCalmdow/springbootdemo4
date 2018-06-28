//package com.flchen.demo4.entity;
//
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//
///**
// * @author feilongchen
// * @create 2018-06-27 1:40 PM
// */
//@Data
//@Document(indexName = "lee", type = "books")
//public class Book {
//
//	@Id
//	@NotNull
//	private Long id;
//
//	@NotEmpty
//	private String name;
//
//	@Min(value = 0)
//	private Double price;
//}
