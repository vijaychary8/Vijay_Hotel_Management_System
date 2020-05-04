package com.capgemini.hotelbookingapp.dao;

import java.util.List;

import com.capgemini.hotelbookingapp.bean.Rooms;

public interface UserDao {

	public boolean selectHotel();

	public List<Rooms> statusList();

}
