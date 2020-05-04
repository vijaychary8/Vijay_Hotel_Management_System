package com.capgemini.hotelbookingapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.factory.Factory;

class AdminDaoImpTest {

	@Test
	void testListOfHotel() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(true, adminDao.listOfHotel());

	}

	@Test
	void testListofReservedRoomsofHotel() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(true, adminDao.listofReservedRoomsofHotel(1));
	}

	@Test
	void testBasedOnGuest() {

		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(true, adminDao.basedOnGuest(1));
	}

	@Test
	void testBasedOnDate() {
		AdminDao adminDao = Factory.getAdminDAOInstance();
		assertEquals(true, adminDao.basedOnDate(LocalDate.of(2020, 04, 23)));
	}

}
