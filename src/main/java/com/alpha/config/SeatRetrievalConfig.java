package com.alpha.config;

import java.net.UnknownHostException;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class SeatRetrievalConfig {
	
	@Bean("mongoClient")
	public MongoClient mongoDbClient() throws UnknownHostException {
		
		MongoClientURI uri = new MongoClientURI("mongodb://mongoClient:Bangalore1@ds111562.mlab.com:11562/seat_allocation_web_app");
		MongoClient mongoClient = new MongoClient(uri);
		
	

		return mongoClient;

	}

}
