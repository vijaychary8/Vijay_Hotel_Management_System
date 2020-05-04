package com.capgemini.hotelbookingapp.validations;

public interface InputValidations {
	public boolean nameValidation(String name);

	public boolean dateValidation(String date);

	public boolean choiceValidateMain(String choice);

	public boolean choiceValidateUser(String choice);

	public boolean roomIdValidation(String roomId);

	public boolean hotelIdValidation(String roomId);

	public boolean emailValidation(String email);

	public boolean ageValidation(String age);

	public boolean aadharValidation(String aadhar);

	public boolean passwordValidation(String password);

	public boolean addressValidation(String address);

	public boolean mobileNoValidation(String phoneNo);

	public boolean registerLoginValidation(String username, String password);

	public boolean hotelManagementLoginValidation(String username, String password);

	public boolean adminLoginValidations(String username, String password);

	public boolean choiceValidateHotel(String option);

	public boolean noOfRoomsValidations(String count);

	public boolean roomTypeValidation(String roomType);

	public boolean roomStatusValidation(String status);

	public boolean roomCostValidation(String status);

	public boolean choiceValidateRoom(String option);

	public boolean choiceValidateReport(String option);

	public boolean choiceValidateAdmin(String option);

	public boolean choiceValidateHotelManagement(String option);

	public boolean customerNameValidation(String userName);

	public boolean hotelDetailsValidations(String hotelDetails);

	public boolean choiceValidation(String option);

	public boolean specificationsChoiceValidation(String option);

	public boolean noOfSpecifiactionsValidation(String count);

}
