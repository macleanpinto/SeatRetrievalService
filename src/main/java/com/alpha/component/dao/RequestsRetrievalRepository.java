package com.alpha.component.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alpha.component.dto.SeatRequestDTO;

public interface RequestsRetrievalRepository extends MongoRepository<SeatRequestDTO, String> {

}
