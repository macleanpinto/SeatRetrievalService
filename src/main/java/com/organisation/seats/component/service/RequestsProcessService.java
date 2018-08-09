package com.organisation.seats.component.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.organisation.seats.component.constants.StatusMsgCd;
import com.organisation.seats.component.controller.RequestsApprovalController;
import com.organisation.seats.component.dto.SeatRequestsApprovalDTO;
import com.organisation.seats.component.dto.StatusDTO;

@RestController
@RequestMapping(value = "/api/requestProcess")
public class RequestsProcessService {

    @Autowired
    @Qualifier(value = "requestsApprovalController")
    private RequestsApprovalController requestsApprovalController;

    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public StatusDTO approveRequests(@RequestBody SeatRequestsApprovalDTO seatsApproved) {
        StatusDTO status = new StatusDTO();
        String responseMsg = StringUtils.EMPTY;
        try {
            responseMsg = this.requestsApprovalController.approveRequests(seatsApproved);
            status.setStatusCd(StatusMsgCd.RESPONSE_200);
            status.setMsg(responseMsg);

        }
        catch (Exception e) {
            status.setStatusCd(StatusMsgCd.RESPONSE_404);
            status.setMsg(StatusMsgCd.NO_RESULT_FOUND);
        }
        return status;

    }

}
