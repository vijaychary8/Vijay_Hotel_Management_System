package com.capgemini.hotelbookingapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.factory.Factory;

class RegistrationDaoImpTest {

	@Test
	void testCustomerRegistration() {

		RegistrationDao registrationDao = Factory.getRegistrationDAOInstance();
		assertEquals(true, registrationDao.customerRegistration());

	}

	@Test
	void testCustomerRegistration2() {

		RegistrationDao registrationDao = Factory.getRegistrationDAOInstance();
		assertEquals(false, registrationDao.customerRegistration());
	}

}
