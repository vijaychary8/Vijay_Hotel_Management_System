package com.capgemini.hotelbookingapp.dao;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.services.AdminService;
import com.capgemini.hotelbookingapp.services.UserService;
import com.capgemini.hotelbookingapp.validations.InputValidations;

public class HotelCrudOperations {

	final Logger log = Logger.getLogger(UserService.class);
	Scanner sc = new Scanner(System.in);

	public boolean hotelCrudOperations() {
		log.info("\n--------------- Hotel  Operations ------------------");
		InputValidations inputValidations = Factory.getInputValidationInstance();
		log.info("\nSelect the options below");
		do {
			log.info("1. Add Hotel ");
			log.info("2. Update Hotel");
			log.info("3. Delete Hotel");
			log.info("4. Back ");
			String option = sc.next();

			while (!inputValidations.choiceValidateHotel(option)) {
				log.info("please enter valid choice");
				option = sc.next();
			}

			Integer choice = Integer.parseInt(option);
			switch (choice) {
			case 1:

				AdminDao adminDao = Factory.getAdminDAOInstance();
				adminDao.addHotel();

				break;

			case 2:
				AdminDao adminDao1 = Factory.getAdminDAOInstance();
				adminDao1.updateHotel();
				break;

			case 3:
				log.info("enter the hotel id to delete");
				String hotelNo = sc.next();
				while (!inputValidations.hotelIdValidation(hotelNo)) {
					log.info("please enter valid HotelID");
					hotelNo = sc.next();
				}

				Integer hotelId = Integer.parseInt(hotelNo);

				AdminDao adminDao3 = Factory.getAdminDAOInstance();
				adminDao3.deleteHotel(hotelId);

				break;
			case 4:

				AdminService adminService = Factory.getAdminServiceInstance();
				adminService.adminService();
				break;
			default:
				log.info("Select correct choice");
				break;
			}

		} while (true);

	}

}
