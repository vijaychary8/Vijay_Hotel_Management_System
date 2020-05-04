package com.capgemini.hotelbookingapp.services;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingapp.controller.AppInfoController;
import com.capgemini.hotelbookingapp.dao.HotelCrudOperations;
import com.capgemini.hotelbookingapp.dao.Report;
import com.capgemini.hotelbookingapp.dao.RoomCrudOperations;
import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.validations.InputValidations;

public class AdminService {
	final Logger log = Logger.getLogger(UserService.class);
	Scanner sc = new Scanner(System.in);

	public void adminService() {

		InputValidations inputValidations = Factory.getInputValidationInstance();
		log.info("\nSelect the options below");
		do {
			log.info("1. Hotel Operations ");
			log.info("2. Room Operations");
			log.info("3. Report");
			log.info("4. logout ");

			String option = sc.next();

			while (!inputValidations.choiceValidateAdmin(option)) {
				log.info("please enter valid choice");
				option = sc.next();
			}

			Integer choice = Integer.parseInt(option);
			switch (choice) {
			case 1:

				HotelCrudOperations adminDao = Factory.getHotelCrudDAOInstance();
				adminDao.hotelCrudOperations();

				break;

			case 2:
				RoomCrudOperations roomCrudOperations = Factory.getRoomCrudDAOInstance();
				roomCrudOperations.roomCrudOperations();
				break;
			case 3:
				Report report = Factory.getReportInstance();
				report.reportList();
				break;
			case 4:
				log.info("Logout Successfull..");
				AppInfoController.main(null);
				break;
			default:
				log.info("Select correct choice");
				break;
			}

		} while (true);
	}

}
