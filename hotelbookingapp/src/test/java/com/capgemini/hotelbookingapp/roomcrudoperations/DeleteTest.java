package com.capgemini.hotelbookingapp.roomcrudoperations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.dao.AdminDao;
import com.capgemini.hotelbookingapp.factory.Factory;

public class DeleteTest {
	@Test
	void testDeleteRoom() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(true, adminDao.deleteRoom(1, 101));

	}

	@Test
	void testDeleteRoom1() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(false, adminDao.deleteRoom(3, 103));

	}

}
