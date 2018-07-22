package com.alpha.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;

@Configuration
public class SeatRetrievalConfig {
	
	@Bean("mongoDbClient")
	public MongoClient mongoDbClient() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient();

		return mongoClient;

	}

}
