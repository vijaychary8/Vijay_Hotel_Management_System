package com.capgemini.hotelbookingapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.factory.Factory;

class UserDaoImpTest {

	@Test
	void testSelectHotel() {
		UserDao userDao = Factory.getUserDAOInstance();
		assertEquals(true, userDao.selectHotel());
	}

	@Test
	void testSelectHotel2() {
		UserDao userDao = Factory.getUserDAOInstance();
		assertEquals(false, userDao.selectHotel());
	}

	@Test
	void testStatusList0() {
		UserDao userDao = Factory.getUserDAOInstance();
		assertNotNull(userDao.statusList());

	}

}
