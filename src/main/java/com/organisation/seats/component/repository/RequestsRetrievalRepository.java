package com.organisation.seats.component.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.organisation.seats.component.dto.SeatRequestDTO;

public interface RequestsRetrievalRepository extends MongoRepository<SeatRequestDTO, String> {

}
