package com.organisation.seats.component.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organisation.seats.component.constants.StatusMsgCd;
import com.organisation.seats.component.dto.ResponseListDTO;
import com.organisation.seats.component.dto.SeatDTO;
import com.organisation.seats.component.repository.SeatsArrangementRepository;

@RestController
@RequestMapping(value = "/api/bayIdsRetrieval")
public class BayIdsRetrievalService {

	@Autowired
	private SeatsArrangementRepository seatsArrangementRepository;

	@RequestMapping(value = "/fetchBayIds", method = RequestMethod.GET, produces = "application/json")
	public ResponseListDTO<String> fetchAllBaysForAFloor(@RequestParam("floor") String floor) {
		ResponseListDTO<String> responseListDTO = new ResponseListDTO<>();
		List<SeatDTO> seatDtoList = new ArrayList<>();
		try {
			seatDtoList = this.seatsArrangementRepository.findByFloor(floor);
			if (CollectionUtils.isNotEmpty(seatDtoList)) {
				responseListDTO.setResults(extractListOfBayIds(seatDtoList));
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

	private List<String> extractListOfBayIds(List<SeatDTO> seatDtoList) {

		Set<String> bayIdSet = new HashSet<String>();
		for (SeatDTO seatDto : seatDtoList) {
			bayIdSet.add(seatDto.getBayId());
		}

		return new ArrayList<>(bayIdSet);
	}
}
