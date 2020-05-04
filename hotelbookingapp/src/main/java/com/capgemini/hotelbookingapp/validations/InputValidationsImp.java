package com.capgemini.hotelbookingapp.validations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingapp.bean.CustomerBean;
import com.capgemini.hotelbookingapp.dao.RegistrationDaoImp;
import com.capgemini.hotelbookingapp.exceptions.CustomerNotFoundException;
import com.capgemini.hotelbookingapp.exceptions.PasswordMissMatchException;

public class InputValidationsImp implements InputValidations {
	Logger log = Logger.getLogger(InputValidationsImp.class);
	Pattern pat = null;
	Matcher mat = null;

	@Override
	public boolean nameValidation(String name) {
		pat = Pattern.compile("^[A-Za-z]+([ A-Za-z]+)*");
		mat = pat.matcher(name);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean roomIdValidation(String roomId) {
		pat = Pattern.compile("[0-9&&[^a-zA-Z]]{3}");
		mat = pat.matcher(roomId);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hotelIdValidation(String hotelId) {
		pat = Pattern.compile("[1-9&&[^a-zA-Z]]{1}");
		mat = pat.matcher(hotelId);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean ageValidation(String name) {
		pat = Pattern.compile("[0-9&&[^a-zA-Z]]{2}");
		mat = pat.matcher(name);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean choiceValidateMain(String choice) {
		pat = Pattern.compile("[1-5&&[^a-zA-Z]]{1}");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean choiceValidateUser(String choice) {
		pat = Pattern.compile("[1-3&&[^a-zA-Z]]{1}");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean dateValidation(String date) {
		pat = Pattern.compile("[0-9]{4}-(0[1-9]|1[0-2])-(3[0-1]|[1-2][0-9]|0[0-9])");
		mat = pat.matcher(date);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean emailValidation(String email) {
		pat = Pattern.compile("^(.+)@(.+)$");
		mat = pat.matcher(email);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean aadharValidation(String aadhar) {
		pat = Pattern.compile("[0-9&&[^a-zA-Z]]{12}");
		mat = pat.matcher(aadhar);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean passwordValidation(String password) {
		pat = Pattern.compile("[[a-zA-Z][@!#$%^&*]{1,}[0-9]{1,}]{10,15}");
		mat = pat.matcher(password);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addressValidation(String address) {
		pat = Pattern.compile("[\\d]+[A-Za-z0-9\\s,\\.]+");
		mat = pat.matcher(address);
		if (mat.matches()) {
			return true;

		}
		return false;
	}

	@Override
	public boolean mobileNoValidation(String phoneNo) {
		pat = Pattern.compile("[6-9][0-9]{9}");
		mat = pat.matcher(phoneNo);
		if (mat.matches()) {
			return true;

		}

		return false;
	}

	@Override
	public boolean registerLoginValidation(String mailId, String password) {
		int count = 0;
		int flag = 0;
		ArrayList<CustomerBean> list2 = new ArrayList<CustomerBean>();
		list2.addAll(RegistrationDaoImp.CustomerList);
		Iterator<CustomerBean> ir = list2.iterator();
		while (ir.hasNext()) {
			CustomerBean ir1 = ir.next();
			if (ir1.getMailId().equals(mailId)) {
				count++;
				if (ir1.getPassword().equals(password)) {
					flag++;
				}
			}
		}
		try {
			if (count == 0) {
				throw new CustomerNotFoundException();
			} else if (flag == 0) {
				throw new PasswordMissMatchException();

			} else {

				return true;
			}
		} catch (CustomerNotFoundException b) {
			log.info("Login Failed");
			log.info("EmailId not found in List .So, Register as new User");
		} catch (PasswordMissMatchException e) {
			log.info("Login Failed");

			log.info("Typed Wrong Password ");

		}
		return false;
	}

	@Override
	public boolean hotelManagementLoginValidation(String username, String password) {

		if (username.equals("vijaychary") && password.equals("9491381997V")) {

			return true;
		}

		return false;
	}

	@Override

	public boolean adminLoginValidations(String username, String password) {

		if (username.equals("admin") && password.equals("admin123")) {

			return true;
		}

		return false;
	}

	@Override
	public boolean choiceValidateHotel(String choice) {
		pat = Pattern.compile("[1-4&&[^a-zA-Z]]{1}");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;

	}

	@Override
	public boolean noOfRoomsValidations(String count) {
		pat = Pattern.compile("[0-9&&[^a-zA-Z]]{1,2}");
		mat = pat.matcher(count);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean roomTypeValidation(String roomType) {
		pat = Pattern.compile("^[A-Za-z]+([ A-Za-z]+)*");
		mat = pat.matcher(roomType);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean roomStatusValidation(String status) {
		pat = Pattern.compile("^[A-Za-z]+([ A-Za-z]+)*");
		mat = pat.matcher(status);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean roomCostValidation(String status) {
		pat = Pattern.compile("[0-9&&[^a-zA-Z]]{1,8}");
		mat = pat.matcher(status);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean choiceValidateRoom(String option) {
		pat = Pattern.compile("[1-4&&[^a-zA-Z]]{1}");
		mat = pat.matcher(option);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean choiceValidateReport(String option) {
		pat = Pattern.compile("[1-5&&[^a-zA-Z]]{1}");
		mat = pat.matcher(option);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean choiceValidateAdmin(String option) {
		pat = Pattern.compile("[1-4&&[^a-zA-Z]]{1}");
		mat = pat.matcher(option);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean choiceValidateHotelManagement(String option) {
		pat = Pattern.compile("[1-4&&[^a-zA-Z]]{1}");
		mat = pat.matcher(option);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean customerNameValidation(String userName) {
		pat = Pattern.compile("^[A-Za-z]+([ A-Za-z]+)*");
		mat = pat.matcher(userName);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hotelDetailsValidations(String hotelDetails) {
		pat = Pattern.compile("^[A-Za-z]+([ A-Za-z]+)*");
		mat = pat.matcher(hotelDetails);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean choiceValidation(String option) {
		pat = Pattern.compile("[1-2&&[^a-zA-Z]]{1}");
		mat = pat.matcher(option);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean specificationsChoiceValidation(String option) {
		pat = Pattern.compile("[1-4&&[^a-zA-Z]]{1}");
		mat = pat.matcher(option);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean noOfSpecifiactionsValidation(String count) {
		pat = Pattern.compile("[1-4&&[^a-zA-Z]]{1}");
		mat = pat.matcher(count);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

}
