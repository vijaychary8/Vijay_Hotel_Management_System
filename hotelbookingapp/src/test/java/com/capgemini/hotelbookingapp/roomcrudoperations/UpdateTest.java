package com.capgemini.hotelbookingapp.roomcrudoperations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.dao.AdminDao;
import com.capgemini.hotelbookingapp.factory.Factory;

public class UpdateTest {
	@Test
	void testUpdateRoom() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(true, adminDao.updateRoom(1, 102));
	}

	@Test
	void testUpdateRoom1() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(false, adminDao.updateRoom(1, 103));
	}
}
