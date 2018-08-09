package com.alpha.component.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.component.constants.StatusMsgCd;
import com.alpha.component.dto.ResponseListDTO;
import com.alpha.component.dto.SeatDTO;
import com.seats.component.repository.SeatsArrangementRepository;

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
				responseListDTO.setStatusCd(StatusMsgCd.RESULT_FOUND);
				responseListDTO.setMsg(StatusMsgCd.RESPONSE_200);
			} else {
				responseListDTO.setStatusCd(StatusMsgCd.NO_RESULT_FOUND);
				responseListDTO.setMsg(StatusMsgCd.RESPONSE_404);
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
