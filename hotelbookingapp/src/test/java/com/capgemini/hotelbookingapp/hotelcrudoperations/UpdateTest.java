package com.capgemini.hotelbookingapp.hotelcrudoperations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.dao.AdminDao;
import com.capgemini.hotelbookingapp.factory.Factory;

public class UpdateTest {

	@Test
	void testUpdateHotel() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(true, adminDao.updateHotel());

	}

	@Test
	void testUpdateHotel1() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(false, adminDao.updateHotel());

	}

}
