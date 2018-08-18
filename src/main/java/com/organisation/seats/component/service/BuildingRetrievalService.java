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
import org.springframework.web.bind.annotation.RestController;

import com.organisation.seats.component.constants.StatusMsgCd;
import com.organisation.seats.component.dto.ResponseListDTO;
import com.organisation.seats.component.dto.SeatDTO;
import com.organisation.seats.component.repository.SeatsArrangementRepository;

@RestController
@RequestMapping(value = "/api/building")
public class BuildingRetrievalService {

	public static Logger logger = LoggerFactory.getLogger(BuildingRetrievalService.class);

	@Autowired
	private SeatsArrangementRepository seatsArrangementRepository;

	@GetMapping(path = "/fetchAllBuildings", produces = "application/json")
	public ResponseListDTO<String> fetchAllBuildings() {
		ResponseListDTO<String> responseListDTO = new ResponseListDTO<>();
		List<SeatDTO> seatDTOList = new ArrayList<>();
		try {
			seatDTOList = this.seatsArrangementRepository.findAll();
			if (CollectionUtils.isNotEmpty(seatDTOList)) {
				responseListDTO.setResults(fetchListOfBuildings(seatDTOList));
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

	private List<String> fetchListOfBuildings(List<SeatDTO> seatDTOList) {
		Set<String> buildings = new HashSet<>();
		seatDTOList.stream().map(eachSeat -> buildings.add(eachSeat.getFloor()));
		return new ArrayList<>(buildings);
	}

}
