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
import org.springframework.web.bind.annotation.RestController;

import com.organisation.seats.component.constants.StatusMsgCd;
import com.organisation.seats.component.dto.ResponseListDTO;
import com.organisation.seats.component.dto.SeatDTO;
import com.organisation.seats.component.repository.SeatsArrangementRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/buildingsRetrieval")
public class BuildingRetrievalService {

	@Autowired
	private SeatsArrangementRepository seatsArrangementRepository;

	@RequestMapping(value = "/fetchAllBuildings", method = RequestMethod.GET, produces = "application/json")
	public ResponseListDTO<String> fetchAllBuildings() {
		ResponseListDTO<String> responseListDTO = new ResponseListDTO<>();
		List<SeatDTO> seatDtoList = new ArrayList<>();
		try {
			seatDtoList = this.seatsArrangementRepository.findAll();
			if (CollectionUtils.isNotEmpty(seatDtoList)) {
				responseListDTO.setResults(fetchListOfBuildings(seatDtoList));
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

	private List<String> fetchListOfBuildings(List<SeatDTO> seatDtoList) {

		Set<String> distinctBuildingNames = new HashSet<String>();
		for (SeatDTO seatDto : seatDtoList) {
			distinctBuildingNames.add(seatDto.getBuilding());
		}

		return new ArrayList<>(distinctBuildingNames);
	}

}
