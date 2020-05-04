package com.capgemini.hotelbookingapp.services;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingapp.controller.AppInfoController;
import com.capgemini.hotelbookingapp.dao.UserDao;
import com.capgemini.hotelbookingapp.dao.UserDaoImp;
import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.validations.InputValidations;

public class HotelManagementService extends UserService {
	Scanner sc = new Scanner(System.in);
	UserDaoImp userDaoImp = new UserDaoImp();

	public void customerService() {
		final Logger log = Logger.getLogger(UserService.class);
		log.info("--------------Welcome to Hotel Management Team------------------");
		InputValidations inputValidations = Factory.getInputValidationInstance();
		log.info("\nSelect the options below");
		do {
			log.info("1. Hotel booking ");
			log.info("2. Booking Status");
			log.info("3. Customer List");
			log.info("4.LogOut");
			String option = sc.next();
			while (!inputValidations.choiceValidateHotelManagement(option)) {
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
				userDaoImp.bookingsStatusList();
				break;
			case 3:
				log.info("------List of users-------------");
				userDaoImp.printList();

				break;
			case 4:
				AppInfoController.main(null);

				break;
			default:

				log.info("Select correct choice");
				break;
			}

		} while (true);
	}

}
