package com.capgemini.hotelbookingapp.exceptions;

@SuppressWarnings("serial")
public class RoomHasBookedAlready extends RuntimeException {
	public RoomHasBookedAlready () {

	}

	public RoomHasBookedAlready(String message) {
		super();
	}

}
