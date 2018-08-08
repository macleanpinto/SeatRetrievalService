package com.alpha.component.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.alpha.component.dto.SeatRequestDTO;
import com.alpha.component.repository.RequestsRetrievalRepository;

@Controller("requestsRetrievalController")
public class RequestsRetrievalController {

//    @Autowired
//    private RequestsRetrievalRepository requestsRetrievalRepository;

    public List<SeatRequestDTO> fetchAllRequests(Integer page, Integer pageSize) {
        Pageable pageableRequest = new PageRequest(page, pageSize);
        Page<SeatRequestDTO> pages = null;//requestsRetrievalRepository.findAll(pageableRequest);
        return pages.getContent();
    }
}
