package com.capgemini.hotelbookingapp.bean;

import java.time.LocalDate;
import java.util.Arrays;

public class Rooms {
	private int hotelId;
	private int roomNo;
	private String roomType;
	private String status;
	private double roomCost;
	private LocalDate from;
	private LocalDate to;
	private String specifications[];
	private String guestName;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
	}

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

	public String[] getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String[] specifications) {
		this.specifications = specifications;
	}

	@Override
	public String toString() {
		return "\n Rooms [\nhotelId=" + hotelId + "\n roomNo=" + roomNo + "\n roomType=" + roomType + "\n status="
				+ status + "\n roomCost=" + roomCost + "\n from=" + from + "\n to=" + to + "\n specifications="
				+ Arrays.toString(specifications) + "\n guestName=" + guestName + "]";
	}

}
