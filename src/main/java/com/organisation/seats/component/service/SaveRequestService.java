package com.organisation.seats.component.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.organisation.seats.component.dto.SeatRequestDTO;
import com.organisation.seats.component.controller.RequestsSaveController;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/saveRequest")
public class SaveRequestService {

	@Autowired
	@Qualifier("requestsSaveController")
	private RequestsSaveController requestsSaveController;

	@RequestMapping(value = "/saveRequestTemplate", method = RequestMethod.POST)
	public void saveTemplate(@RequestBody SeatRequestDTO seatRequestDTO) {
		this.requestsSaveController.saveRequestTemplate(seatRequestDTO);

	}
}
