package com.alpha.component.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.component.constants.StatusMsgCd;
import com.alpha.component.dto.ResponseListDTO;
import com.alpha.component.dto.SeatDTO;
import com.seats.component.repository.SeatsArrangementRepository;

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

            Sort sortByRowId = new Sort(Direction.ASC, "rowId");
            seatResponseList = this.seatsArrangementRepository.findByBayIdAndFloorAndBuildingOrderByRowIdAscColIdAsc(bayId,
                    floor, building);
            if (CollectionUtils.isNotEmpty(seatResponseList)) {
                responseListDTO.setResults(convertSeatDTOToDO(seatResponseList));
                responseListDTO.setStatusCd(StatusMsgCd.RESULT_FOUND);
                responseListDTO.setMsg(StatusMsgCd.RESPONSE_200);
            }
            else {
                responseListDTO.setStatusCd(StatusMsgCd.NO_RESULT_FOUND);
                responseListDTO.setMsg(StatusMsgCd.RESPONSE_404);
            }
        }
        catch (Exception e) {

        }
        return responseListDTO;

    }

    private List<List<SeatDTO>> convertSeatDTOToDO(List<SeatDTO> listOfSeat) {
        List<List<SeatDTO>> SeatDTOList = new ArrayList<List<SeatDTO>>();

        int prevRowNum = -1;
        for (SeatDTO seatDto : listOfSeat) {
            List<SeatDTO> seatList = null;
            if (seatDto.getRowId() > prevRowNum) {
                seatList = new ArrayList<>();
                seatList.add(seatDto);
                SeatDTOList.add(seatList);
            }
            else {
                SeatDTOList.get(seatDto.getRowId()).add(seatDto);
            }
            prevRowNum = seatDto.getRowId();

        }

        return SeatDTOList;
    }

}
