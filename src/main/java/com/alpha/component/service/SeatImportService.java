package com.alpha.component.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seats.arrangement.dao.SeatsArrangementRepository;
import com.seats.arrangement.dto.SeatDTO;

@RestController
@RequestMapping(value = "/api/import/")
@CrossOrigin(maxAge = 3600)
@EnableMongoRepositories("com.seats.arrangement.dao")
public class SeatImportService {

	@Autowired
	private SeatsArrangementRepository seatsArrangementRepository;

	@RequestMapping(value = "/saveSeatingTemplate", method = RequestMethod.POST)
	public void saveTemplate(@RequestBody List<SeatDTO> listOfSeatsList) {
		seatsArrangementRepository.save(listOfSeatsList);
	}
}
