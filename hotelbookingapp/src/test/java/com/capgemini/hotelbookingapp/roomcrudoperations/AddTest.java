package com.capgemini.hotelbookingapp.roomcrudoperations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.dao.AdminDao;
import com.capgemini.hotelbookingapp.factory.Factory;

public class AddTest {
	@Test
	void testAddRooms() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(true, adminDao.addRooms());

	}

	@Test
	void testAddRooms1() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(false, adminDao.addRooms());

	}

}
