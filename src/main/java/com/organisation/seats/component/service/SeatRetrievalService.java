package com.organisation.seats.component.service;

import java.util.ArrayList;
import java.util.List;

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
import com.organisation.seats.component.utils.SeatUtils;

@RestController
@RequestMapping(value = "/api/seatRetrieval")
public class SeatRetrievalService {

    @Autowired
    private SeatsArrangementRepository seatsArrangementRepository;

    @RequestMapping(value = "/fetchLayout", method = RequestMethod.GET, produces = "application/json")
    public ResponseListDTO<List<SeatDTO>> fetchBayLayout(@RequestParam("bayId") String bayId,
            @RequestParam("floor") String floor, @RequestParam("building") String building) {
        ResponseListDTO<List<SeatDTO>> responseListDTO = new ResponseListDTO<>();
        List<SeatDTO> seatResponseList = new ArrayList<>();
        try {

            seatResponseList = this.seatsArrangementRepository
                    .findByBayIdAndFloorAndBuildingOrderByRowIdAscColIdAsc(bayId, floor, building);
            if (CollectionUtils.isNotEmpty(seatResponseList)) {
                responseListDTO.setResults(SeatUtils.convertSeatDTOToDO(seatResponseList));
                responseListDTO.setStatusCd(StatusMsgCd.RESPONSE_200);
                responseListDTO.setMsg(StatusMsgCd.RESULT_FOUND);
            }
            else {
                responseListDTO.setStatusCd(StatusMsgCd.RESPONSE_404);
                responseListDTO.setMsg(StatusMsgCd.NO_RESULT_FOUND);
            }
        }
        catch (Exception e) {

        }
        return responseListDTO;

    }

}
