package com.organisation.seats.component.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organisation.seats.component.constants.StatusMsgCd;
import com.organisation.seats.component.dto.ResponseListDTO;
import com.organisation.seats.component.dto.SeatDTO;
import com.organisation.seats.component.repository.SeatsArrangementRepository;

@RestController
@RequestMapping(value = "/api/bay")
public class BayIdsRetrievalService {

	public static Logger logger = LoggerFactory.getLogger(BayIdsRetrievalService.class);

	@Autowired
	private SeatsArrangementRepository seatsArrangementRepository;

	@GetMapping(value = "/fetchBaysByFloor", produces = "application/json")
	public ResponseListDTO<String> fetchBaysByFloor(@RequestParam("floor") String floor) {
		ResponseListDTO<String> responseListDTO = new ResponseListDTO<>();
		List<SeatDTO> seatDTOList = new ArrayList<>();
		try {
			seatDTOList = this.seatsArrangementRepository.findByFloor(floor);
			if (CollectionUtils.isNotEmpty(seatDTOList)) {
				responseListDTO.setResults(extractListOfBayIds(seatDTOList));
				responseListDTO.setStatusCd(StatusMsgCd.RESPONSE_200);
				responseListDTO.setMsg(StatusMsgCd.RESULT_FOUND);
			} else {
				responseListDTO.setStatusCd(StatusMsgCd.RESPONSE_404);
				responseListDTO.setMsg(StatusMsgCd.NO_RESULT_FOUND);
			}
		} catch (Exception e) {
			logger.info("Exception occurred: ", e);
			responseListDTO.setStatusCd(StatusMsgCd.RESPONSE_500);
			responseListDTO.setMsg(StatusMsgCd.ERROR_500);
		}
		return responseListDTO;

	}

	private List<String> extractListOfBayIds(List<SeatDTO> seatDTOList) {
		Set<String> filteredBays = new HashSet<>();
		for (SeatDTO eachSeat : seatDTOList) {
			filteredBays.add(eachSeat.getFloor());
		}
		return new ArrayList<>(filteredBays);
	}
}
