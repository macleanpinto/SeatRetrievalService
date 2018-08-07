package com.alpha.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.dto.BayLayoutDTO;
import com.alpha.dto.BayRequestDTO;

@RestController
@RequestMapping(value = "/api/seatRetrieval")
public class SeatRetrievalService {
//	@Autowired
//	@Qualifier("seatRetrievalController")
//	SeatRetrievalController seatRetrievalController;

	@RequestMapping(value = "/fetchLayout", method = RequestMethod.GET)
	public BayLayoutDTO fetchBayLayout() {
		BayRequestDTO bayRequestDTO = new BayRequestDTO();
		bayRequestDTO.setBayId("BLR-112");
		bayRequestDTO.setFloorNumber(5);
		bayRequestDTO.setWingId("C1");
		BayLayoutDTO baylayout = null;
		try {
			//baylayout = this.seatRetrievalController.fetchBayLayout(bayRequestDTO);
		} catch (Exception e) {

		}

		return baylayout;
	}

}
