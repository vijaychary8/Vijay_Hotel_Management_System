package com.capgemini.hotelbookingapp.bean;

public class HotelBean {

	private int hotelId;
	private String hotelName;
	private String hotelAddress;
	private String hotelDetails;
	private int noOfRooms;

	// Rooms room;
	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelDetails() {
		return hotelDetails;
	}

	public void setHotelDetails(String hotelDetails) {
		this.hotelDetails = hotelDetails;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	@Override
	public String toString() {
		return "\n [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddress=" + hotelAddress
				+ ", hotelDetails=" + hotelDetails + ", noOfRooms=" + noOfRooms + "]";
	}

}
