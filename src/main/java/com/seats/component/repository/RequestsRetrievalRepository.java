package com.seats.component.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.seats.component.dto.SeatRequestDTO;

public interface RequestsRetrievalRepository extends MongoRepository<SeatRequestDTO, String> {

}
