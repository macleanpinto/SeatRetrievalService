package com.organisation.seats.component.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.organisation.seats.component.dto.SeatRequestDTO;
import com.organisation.seats.component.repository.RequestsRetrievalRepository;

@Controller("requestsSaveController")
public class RequestsSaveController {

    @Autowired
    private RequestsRetrievalRepository requestsRetrievalRepository;
    
	public void saveRequestTemplate(SeatRequestDTO seatRequestDTO) {
		requestsRetrievalRepository.save(seatRequestDTO);
	}
}
