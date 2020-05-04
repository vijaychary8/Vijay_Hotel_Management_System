package com.capgemini.hotelbookingapp.services;

import static org.junit.jupiter.api.Assertions.*;

import com.capgemini.hotelbookingapp.dao.UserDao;
import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.validations.InputValidations;

import org.junit.jupiter.api.Test;

class UserServiceTest {

	@Test
	void testUserLogin() {
		InputValidations inputValidations = Factory.getInputValidationInstance();
		assertEquals(false, inputValidations.registerLoginValidation("vijay", "vijaychary8"));
	}

	@Test
	void testUserLogin1() {
		InputValidations inputValidations = Factory.getInputValidationInstance();
		assertEquals(true, inputValidations.registerLoginValidation("vijaychary8@gmail.com", "vijaychary8"));
	}

}
