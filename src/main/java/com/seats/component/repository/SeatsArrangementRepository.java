package com.seats.component.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alpha.component.dto.SeatDTO;

public interface SeatsArrangementRepository extends MongoRepository<SeatDTO, String> {

    public List<SeatDTO> findByBayIdAndFloorAndBuildingOrderByRowIdAscColIdAsc(String bayId, String floor,
            String building);
    
    public List<SeatDTO> findByBuilding(String building);

}

	

