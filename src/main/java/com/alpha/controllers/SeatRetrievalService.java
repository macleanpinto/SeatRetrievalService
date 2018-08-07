package com.alpha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.component.controller.SeatRetrievalController;
import com.alpha.dto.BayLayoutDTO;
import com.alpha.dto.BayRequestDTO;
import com.alpha.model.Employee;

@RestController
@RequestMapping(value = "/api/seatRetrieval")
public class SeatRetrievalService {
	@Autowired
	@Qualifier("seatRetrievalController")
	SeatRetrievalController seatRetrievalController;

	@RequestMapping(value = "/fetchLayout", method = RequestMethod.GET)
	public BayLayoutDTO fetchBayLayout( @RequestParam("bayId") String bayId, @RequestParam("floorId") String floorId,@RequestParam("wingId") String wingId) {
		BayRequestDTO bayRequestDTO = new BayRequestDTO();
		bayRequestDTO.setBayId(bayId);
		bayRequestDTO.setFloorNumber(Integer.valueOf(floorId));
		bayRequestDTO.setWingId(wingId);
		BayLayoutDTO baylayout = null;
		try {
			baylayout = this.seatRetrievalController.fetchBayLayout(bayRequestDTO);
		} catch (Exception e) {

		}

		return baylayout;
	}

}
