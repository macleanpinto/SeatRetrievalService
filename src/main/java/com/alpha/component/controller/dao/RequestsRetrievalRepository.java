package com.alpha.component.controller.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alpha.dto.SeatRequestDTO;

public interface RequestsRetrievalRepository extends MongoRepository<SeatRequestDTO, String> {

}
