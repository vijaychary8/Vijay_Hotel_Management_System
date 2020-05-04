package com.capgemini.hotelbookingapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.dao.UserDao;
import com.capgemini.hotelbookingapp.dao.UserDaoImp;
import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.validations.InputValidations;

public class EmoloyeeServiceTest {

	@Test
	public void employeeLogin() {
		InputValidations inputValidations = Factory.getInputValidationInstance();
		assertEquals(true, inputValidations.hotelManagementLoginValidation("vijaychary", "9491381997V"));
	}

	@Test
	public void employeeLogin1() {
		InputValidations inputValidations = Factory.getInputValidationInstance();
		assertEquals(false, inputValidations.hotelManagementLoginValidation("varun", "9491381997V"));
	}

	@Test
	public void bookingStatusTest() {
		UserDaoImp userDaoImp = new UserDaoImp();
		assertNotNull(userDaoImp.bookingsStatusList());
	}

}
