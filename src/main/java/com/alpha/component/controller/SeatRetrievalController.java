package com.alpha.component.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.alpha.component.SeatRetrievalDAO;
import com.alpha.dto.BayLayoutDTO;
import com.alpha.dto.BayRequestDTO;
import com.alpha.dto.SeatsInfoDTO;

@Controller("seatRetrievalController")
public class SeatRetrievalController {

	@Autowired
    @Qualifier("seatRetrievalDAO")
	SeatRetrievalDAO seatRetreivalDAO;
	
	public BayLayoutDTO fetchBayLayout(BayRequestDTO bayRequest) {
		String layoutId=seatRetreivalDAO.fetchLayoutIds(bayRequest);
		List<SeatsInfoDTO> seatsInfoDTOs=this.seatRetreivalDAO.fetchSeatsLayout(layoutId);
		
		BayLayoutDTO bayLayout=new BayLayoutDTO();
		bayLayout.setBayId(bayRequest.getBayId());
		bayLayout.setFloorNumber(Long.valueOf(bayRequest.getFloorNumber()));
		bayLayout.setSeatInfo(seatsInfoDTOs);
		bayLayout.setWingId(bayRequest.getWingId());
		
		return bayLayout;
		
		
	}
	
}
