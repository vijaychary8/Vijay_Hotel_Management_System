package com.capgemini.hotelbookingapp.hotelcrudoperations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.dao.AdminDao;
import com.capgemini.hotelbookingapp.factory.Factory;

public class DeleteTest {
	@Test
	void testDeleteHotel() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(true, adminDao.deleteHotel(1));

	}

	@Test
	void testDeleteHotel1() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(false, adminDao.deleteHotel(3));
	}

}
