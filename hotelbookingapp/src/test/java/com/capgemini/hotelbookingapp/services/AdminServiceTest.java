package com.capgemini.hotelbookingapp.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.validations.InputValidations;

class AdminServiceTest {

	@Test
	void testAdminLogin() {
		InputValidations inputValidations = Factory.getInputValidationInstance();
		assertEquals(true, inputValidations.adminLoginValidations("vijaychary", "9491381997V"));
	}

	@Test
	void testAdminLogin2() {
		InputValidations inputValidations = Factory.getInputValidationInstance();
		assertEquals(false, inputValidations.adminLoginValidations("vijay", "vijaychary8@"));
	}

}
