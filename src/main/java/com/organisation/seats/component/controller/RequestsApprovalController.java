package com.organisation.seats.component.controller;

import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.organisation.seats.component.constants.RequestsContants;
import com.organisation.seats.component.dto.SeatDTO;
import com.organisation.seats.component.dto.SeatRequestDTO;
import com.organisation.seats.component.dto.SeatRequestsApprovalDTO;
import com.organisation.seats.component.repository.RequestsRetrievalRepository;
import com.organisation.seats.component.repository.SeatsArrangementRepository;

@Controller("requestsApprovalController")
public class RequestsApprovalController {

    private static final String ERROR_FINDING_REQUEST_ID = "Request Id does not exist in the system.";

    private static final String SEAT_STATUS_UPDATE_SUCCESS_MSG = "Request has been successfully Approved and Seats have been Booked.";

    @Autowired
    private RequestsRetrievalRepository requestsRetrievalRepository;

    @Autowired
    private SeatsArrangementRepository seatsArrangementRepository;

    public String approveRequests(SeatRequestsApprovalDTO seatsApproved) {
        Optional<SeatRequestDTO> optionalSeatRequest = this.requestsRetrievalRepository
                .findById(seatsApproved.getRequestId());
        String responseMsg = StringUtils.EMPTY;
        if (optionalSeatRequest.isPresent()) {
            SeatRequestDTO seatRequest = optionalSeatRequest.get();
            Iterable<SeatDTO> approvedSeatsList = this.seatsArrangementRepository
                    .findAllById(seatsApproved.getSeatIds());
            for (SeatDTO eachSeat : approvedSeatsList) {
                eachSeat.setRequestId(seatsApproved.getRequestId());
                eachSeat.setOccupancy(RequestsContants.SEAT_OCCUPIED);
            }
            this.seatsArrangementRepository.saveAll(approvedSeatsList);
            seatRequest.setStatus(RequestsContants.APPROVED);
            this.requestsRetrievalRepository.save(seatRequest);
            responseMsg = SEAT_STATUS_UPDATE_SUCCESS_MSG;

        }
        else {
            responseMsg = ERROR_FINDING_REQUEST_ID;
        }
        return responseMsg;

    }
}
