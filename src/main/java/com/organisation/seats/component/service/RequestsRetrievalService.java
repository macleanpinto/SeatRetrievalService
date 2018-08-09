package com.organisation.seats.component.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organisation.seats.component.constants.StatusMsgCd;
import com.organisation.seats.component.controller.RequestsRetrievalController;
import com.organisation.seats.component.dto.ResponseListDTO;
import com.organisation.seats.component.dto.SeatRequestDTO;

@RestController
@RequestMapping(value = "/api/requestsRetrieval")
public class RequestsRetrievalService {

    @Autowired
    @Qualifier("requestsRetrievalController")
    private RequestsRetrievalController requestsRetrievalController;

    @RequestMapping(value = "/fetchAllRequests", method = RequestMethod.GET, produces = "application/json")
    public ResponseListDTO<SeatRequestDTO> fetchAllRequests(@RequestParam("page") Integer page,
            @RequestParam("size") Integer pageSize) {
        ResponseListDTO<SeatRequestDTO> responseListDTO = new ResponseListDTO<>();
        List<SeatRequestDTO> seatRequestList = new ArrayList<>();
        try {
            seatRequestList = this.requestsRetrievalController.fetchAllRequests(page, pageSize);
            if (CollectionUtils.isNotEmpty(seatRequestList)) {
                responseListDTO.setResults(seatRequestList);
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
