package com.organisation.seats.component.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organisation.seats.component.constants.StatusMsgCd;
import com.organisation.seats.component.dto.ResponseListDTO;
import com.organisation.seats.component.dto.SeatDTO;
import com.organisation.seats.component.repository.SeatsArrangementRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/floorRetrieval")
public class FloorRetrievalService {

	@Autowired
	private SeatsArrangementRepository seatsArrangementRepository;

	@RequestMapping(value = "/fetchFloorDetail", method = RequestMethod.GET, produces = "application/json")
	public ResponseListDTO<String> fetchAllRequests(@RequestParam("building") String building) {
		ResponseListDTO<String> responseListDTO = new ResponseListDTO<>();
		List<SeatDTO> seatList = new ArrayList<>();
		try {
			seatList = this.seatsArrangementRepository.findByBuilding(building);
			if (CollectionUtils.isNotEmpty(seatList)) {
				responseListDTO.setResults(fetchFloorNumber(seatList));
				responseListDTO.setStatusCd(StatusMsgCd.RESPONSE_200);
				responseListDTO.setMsg(StatusMsgCd.RESULT_FOUND);
			} else {
				responseListDTO.setStatusCd(StatusMsgCd.RESPONSE_404);
				responseListDTO.setMsg(StatusMsgCd.NO_RESULT_FOUND);
			}
		} catch (Exception e) {

		}
		return responseListDTO;
	}

	private List<String> fetchFloorNumber(List<SeatDTO> seatList) {
		Set<String> floorNumberSet = new HashSet<>();
		for (SeatDTO seatDTO : seatList) {
			floorNumberSet.add(seatDTO.getFloor());
		}
		return new ArrayList<>(floorNumberSet);

	}
}
