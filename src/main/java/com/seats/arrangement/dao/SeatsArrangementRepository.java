package com.seats.arrangement.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.seats.arrangement.dto.SeatDTO;

public interface SeatsArrangementRepository extends MongoRepository<SeatDTO, String>  {

}
