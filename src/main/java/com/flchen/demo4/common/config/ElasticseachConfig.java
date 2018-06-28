//package com.flchen.demo4.common.config;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
///**
// * @author feilongchen
// * @create 2018-06-27 1:58 PM
// */
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com/flchen/demo4/")
//public class ElasticseachConfig {
//
//	private Settings settings() {
//		Settings settings = Settings.builder().put("cluster.name", "").put("client.transport.sniff", true).build();
//		return settings;
//	}
//	@Bean
//	public Client client() {
//		TransportClient client = TransportClient.builder().settings(settings()).build();
//		return client;
//	}
//
//	@Bean
//	public ElasticsearchTemplate elasticsearchTemplate() {
//		return new ElasticsearchTemplate(client());
//	}
//}
