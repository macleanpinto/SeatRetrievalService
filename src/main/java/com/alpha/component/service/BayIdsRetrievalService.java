package com.alpha.component.service;

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

import com.alpha.component.constants.StatusMsgCd;
import com.alpha.component.dto.ResponseListDTO;
import com.alpha.component.dto.SeatDTO;
import com.seats.component.repository.SeatsArrangementRepository;

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

	private List<String> extractListOfBayIds(List<SeatDTO> seatDtoList) {

		Set<String> bayIdSet = new HashSet<String>();
		for (SeatDTO seatDto : seatDtoList) {
			bayIdSet.add(seatDto.getBayId());
		}

		return new ArrayList<>(bayIdSet);
	}
}
