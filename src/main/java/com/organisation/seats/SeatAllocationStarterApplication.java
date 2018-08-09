package com.organisation.seats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories("com.organisation.seats.component.repository")
public class SeatAllocationStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeatAllocationStarterApplication.class, args);
    }
}