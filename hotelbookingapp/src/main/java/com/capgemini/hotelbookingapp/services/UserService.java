package com.capgemini.hotelbookingapp.services;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingapp.controller.AppInfoController;
import com.capgemini.hotelbookingapp.dao.UserDao;
import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.validations.InputValidations;

public class UserService {
	final Logger log = Logger.getLogger(UserService.class);
	Scanner sc = new Scanner(System.in);

	public void customerService() {
		log.info("\n--------------Welcome to Online Hotel Booking System------------------");

		InputValidations inputValidations = Factory.getInputValidationInstance();
		log.info("\nSelect the options below");
		do {
			log.info("1. Hotel booking ");
			log.info("2. Booking Status");
			log.info("3. Exit");
			String option = sc.next();
			while (!inputValidations.choiceValidateUser(option)) {
				log.info("please enter valid choice");
				option = sc.next();
			}
			Integer choice = Integer.parseInt(option);
			switch (choice) {
			case 1:

				UserDao userDao = Factory.getUserDAOInstance();
				userDao.selectHotel();

				break;

			case 2:
				UserDao userDao1 = Factory.getUserDAOInstance();
				userDao1.statusList();
				break;

			case 3:
				AppInfoController.main(null);
				break;
			default:
				log.info("Select correct choice");
				break;
			}

		} while (true);
	}
}
