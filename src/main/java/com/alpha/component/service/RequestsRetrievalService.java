package com.alpha.component.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.component.constants.StatusMsgCd;
import com.alpha.component.controller.RequestsRetrievalController;
import com.alpha.component.dto.ResponseListDTO;
import com.alpha.component.dto.SeatRequestDTO;

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

}
