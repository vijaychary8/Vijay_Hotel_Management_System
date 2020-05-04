package com.capgemini.hotelbookingapp.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.services.AdminService;
import com.capgemini.hotelbookingapp.services.HotelManagementService;
import com.capgemini.hotelbookingapp.services.RegisterService;
import com.capgemini.hotelbookingapp.services.UserService;
import com.capgemini.hotelbookingapp.validations.InputValidations;

public class AppInfoController {
	static final Logger log = Logger.getLogger(AppInfoController.class);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		InputValidations inputValidations = Factory.getInputValidationInstance();
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		log.info("\nSelect the options below");
		do {
			log.info("1. User Login");
			log.info("2. Employee Login");
			log.info("3. Admin Login");
			log.info("4. Register (New User)");
			log.info("5. Exit");
			String option = sc.next();
			while (!inputValidations.choiceValidateMain(option)) {
				log.info("please enter valid choice");
				option = sc.next();
			}
			Integer choice = Integer.parseInt(option);
			switch (choice) {
			case 1:
				log.info("----User login---\n");
				log.info("enter your MailId");
				String mailId = sc.next();
				while (!inputValidations.emailValidation(mailId)) {
					log.info("please enter valid  mailId");
					mailId = sc.next();
				}

				log.info("enter your Password");
				String password = sc.next();
				while (!inputValidations.passwordValidation(password)) {
					log.info("please enter valid password");
					password = sc.next();
				}

				boolean IsValid = inputValidations.registerLoginValidation(mailId, password);
				if (IsValid == true) {
					log.info("Login Successfully..........");

					UserService userService = Factory.getUserServiceInstance();
					userService.customerService();
				}
				break;

			case 2:
				log.info("-------------Employee Login----------------");
				String EmployeeName = props.getProperty("employeeName");
				String EmployeePassword = props.getProperty("employeePassword");

				boolean IsValid1 = inputValidations.hotelManagementLoginValidation(EmployeeName, EmployeePassword);
				if (IsValid1 == true) {
					log.info("\n login successfully...");

					HotelManagementService hotelManagementService = Factory.getHotelManagementServiceInstance();
					hotelManagementService.customerService();
				} else {
					log.info("Login failed");
					log.info("invalid username or password");
				}

				break;

			case 3:
				String userName1 = props.getProperty("adminName");

				String password1 = props.getProperty("AdminPassword");

				boolean IsValid2 = inputValidations.adminLoginValidations(userName1, password1);
				if (IsValid2 == true) {
					log.info("\n login suceesfull...");

					AdminService adminService = Factory.getAdminServiceInstance();
					adminService.adminService();
				} else {
					log.info("Login failed");

					log.info("invalid username or password");
				}

				break;
			case 4:
				RegisterService registerService = Factory.getRegisterServiceInstance();
				log.info("\n--------Enter the details for registration----------");
				registerService.registerService();
				break;
			case 5:
				log.info("Thank you");
				System.exit(0);
				break;
			default:
				log.info("Select correct choice");
				break;
			}
		} while (true);

	}

}
