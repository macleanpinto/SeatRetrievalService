package com.seats.component.dto;

public class SeatsInfoDTO {

	String seatId;
	String seatName;
	Long seatRowNum;
	Long seatColumn;
	Long layoutId;
	String seatOccupant;
	
	public String getSeatOccupant() {
		return seatOccupant;
	}
	public void setSeatOccupant(String seatOccupant) {
		this.seatOccupant = seatOccupant;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public Long getSeatRowNum() {
		return seatRowNum;
	}
	public void setSeatRowNum(Long seatRowNum) {
		this.seatRowNum = seatRowNum;
	}
	public Long getSeatColumn() {
		return seatColumn;
	}
	public void setSeatColumn(Long seatColumn) {
		this.seatColumn = seatColumn;
	}
	public Long getLayoutId() {
		return layoutId;
	}
	public void setLayoutId(Long layoutId) {
		this.layoutId = layoutId;
	}
	
	
}
