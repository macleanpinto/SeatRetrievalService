package com.organisation.seats.component.utils;

import java.util.ArrayList;
import java.util.List;

import com.organisation.seats.component.dto.SeatDTO;

public class SeatUtils {
    public static List<List<SeatDTO>> convertSeatDTOToDO(List<SeatDTO> listOfSeat) {
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
