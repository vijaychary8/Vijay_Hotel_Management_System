package com.capgemini.hotelbookingapp.hotelcrudoperations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.dao.AdminDao;
import com.capgemini.hotelbookingapp.factory.Factory;

public class AddTest {
	@Test
	void testAddHotel() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(true, adminDao.addHotel());
	}

	@Test
	void testAddHotel1() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(false, adminDao.addHotel());
	}

}
