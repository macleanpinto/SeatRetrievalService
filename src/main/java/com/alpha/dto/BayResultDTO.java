package com.alpha.dto;

import java.util.List;

public class BayResultDTO {
	String bayId;

	String wingId;

	Long floorNumber;
	
	List<String> seatId;
	
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
	public List<String> getSeatId() {
		return seatId;
	}
	public void setSeatId(List<String> seatId) {
		this.seatId = seatId;
	}

}
