package com.alpha.component.dto;

import java.util.List;

public class BayLayoutDTO {
	String bayId;

	String wingId;

	Long floorNumber;
	
	List<SeatsInfoDTO> seatInfo;

	public String getBayId() {
		return bayId;
	}

	public void setBayId(String bayId) {
		this.bayId = bayId;
	}

	public String getWingId() {
		return wingId;
	}

	public void setWingId(String wingId) {
		this.wingId = wingId;
	}

	public Long getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Long floorNumber) {
		this.floorNumber = floorNumber;
	}

	public List<SeatsInfoDTO> getSeatInfo() {
		return seatInfo;
	}

	public void setSeatInfo(List<SeatsInfoDTO> seatInfo) {
		this.seatInfo = seatInfo;
	}
}
