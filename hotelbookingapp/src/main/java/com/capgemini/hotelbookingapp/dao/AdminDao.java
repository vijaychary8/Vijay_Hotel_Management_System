package com.capgemini.hotelbookingapp.dao;

import java.time.LocalDate;

public interface AdminDao {

	public boolean addHotel();

	public boolean addRooms();

	public boolean updateHotel();

	public boolean deleteHotel(int hotelId);

	public boolean updateRoom(int hotelId, int roomNo);

	public boolean deleteRoom(int hotelId, int roomId);

	public boolean listOfHotel();

	public boolean listofReservedRoomsofHotel(int hotelId);

	public boolean basedOnGuest(int hotelId);

	public boolean basedOnDate(LocalDate bookedDate);
}
