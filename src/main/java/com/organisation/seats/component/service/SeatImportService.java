package com.organisation.seats.component.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.organisation.seats.component.dto.SeatDTO;
import com.organisation.seats.component.repository.SeatsArrangementRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/import/")
public class SeatImportService {

    @Autowired
    private SeatsArrangementRepository seatsArrangementRepository;

    @RequestMapping(value = "/saveSeatingTemplate", method = RequestMethod.POST)
    public void saveTemplate(@RequestBody List<SeatDTO> listOfSeatsList) {
        this.seatsArrangementRepository.saveAll(listOfSeatsList);

    }
}
