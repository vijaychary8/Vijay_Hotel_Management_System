package com.capgemini.hotelbookingapp.validations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelbookingapp.factory.Factory;

class InputValidationsImpTest {
	InputValidations inputValidations = Factory.getInputValidationInstance();

	@Test

	@DisplayName("Name Validation")
	void testNameValidation() {

		assertEquals(true, inputValidations.nameValidation("vijay chary"));

	}

	@Test
	void testRoomIdValidation() {
		assertEquals(true, inputValidations.roomIdValidation("103"));
	}

	@Test
	void testHotelIdValidation() {
		assertEquals(true, inputValidations.hotelIdValidation("1"));
	}

	@Test
	void testAgeValidation() {
		assertEquals(true, inputValidations.ageValidation("50"));
	}

	@Test
	void testChoiceValidateMain() {
		assertEquals(true, inputValidations.choiceValidateMain("4"));
	}

	@Test
	void testChoiceValidateUser() {
		assertEquals(true, inputValidations.choiceValidateUser("3"));
	}

	@Test
	void testDateValidation() {
		assertEquals(true, inputValidations.dateValidation("2020-01-03"));
	}

	@Test
	void testEmailValidation() {
		assertEquals(true, inputValidations.emailValidation("vijaychary8@gmail.com"));
	}

	@Test
	void testAadharValidation() {
		assertEquals(true, inputValidations.aadharValidation("123456789963"));
	}

	@Test
	void testPasswordValidation() {
		assertEquals(true, inputValidations.passwordValidation("Vijaychary8@"));
	}

	/*
	 * @Test void testAddressValidation() { fail("Not yet implemented"); }
	 **/

	@Test
	void testMobileNoValidation() {
		assertEquals(true, inputValidations.mobileNoValidation("9493819774"));
	}

	@Test
	void testChoiceValidateHotel() {
		assertEquals(true, inputValidations.choiceValidateHotel("2"));
	}

	@Test
	void testNoOfRoomsValidations() {
		assertEquals(true, inputValidations.noOfRoomsValidations("10"));
	}

	@Test
	void testRoomTypeValidation() {
		assertEquals(true, inputValidations.roomTypeValidation("Five Star Hotel"));
	}

	@Test
	void testRoomStatusValidation() {
		assertEquals(true, inputValidations.roomStatusValidation("Available"));
	}

	@Test
	void testRoomCostValidation() {
		assertEquals(true, inputValidations.roomCostValidation("1000"));
	}

	@Test
	void testChoiceValidateRoom() {
		assertEquals(true, inputValidations.choiceValidateRoom("3"));
	}

	@Test
	void testChoiceValidateReport() {
		assertEquals(true, inputValidations.choiceValidateReport("2"));
	}

	@Test
	void testChoiceValidateAdmin() {
		assertEquals(true, inputValidations.choiceValidateAdmin("4"));
	}

	@Test
	void testChoiceValidateHotelManagement() {
		assertEquals(true, inputValidations.choiceValidateHotelManagement("1"));
	}

	@Test
	void testCustomerNameValidation() {
		assertEquals(true, inputValidations.customerNameValidation("Vijay chary"));
	}

	@Test
	void testAddressValidation() {
		assertEquals(true, inputValidations.addressValidation("124,kalimandir,hyderabad"));

	}

	@Test
	void testHotelDetailsValidations() {
		assertEquals(true, inputValidations.hotelDetailsValidations("five star hotel"));
	}

	@Test
	void testChoiceValidation() {
		assertEquals(true, inputValidations.choiceValidation("2"));
	}

	@Test
	void testSpecificationsChoiceValidation() {
		assertEquals(true, inputValidations.specificationsChoiceValidation("2"));
	}

	@Test
	void testNoOfSpecifiactionsValidation() {
		assertEquals(true, inputValidations.specificationsChoiceValidation("2"));
	}

}
