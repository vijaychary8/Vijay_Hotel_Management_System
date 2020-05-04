package com.capgemini.hotelbookingapp.dao;

import java.time.LocalDate;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.services.AdminService;
import com.capgemini.hotelbookingapp.services.UserService;
import com.capgemini.hotelbookingapp.validations.InputValidations;

public class Report {
	final Logger log = Logger.getLogger(UserService.class);

	Scanner sc = new Scanner(System.in);

	public void reportList() {

		InputValidations inputValidations = Factory.getInputValidationInstance();
		log.info("\nSelect the options below");
		do {
			log.info("1. List of Hotels");
			log.info("2. List of Specified Hotel bookings");
			log.info("3. List of Specific hotel booked by Guest");
			log.info("4. List of Hotel Bookings on Specifed date ");
			log.info("5. back");
			String option = sc.next();

			while (!inputValidations.choiceValidateReport(option)) {
				log.info("please enter valid choice");
				option = sc.next();
			}

			Integer choice = Integer.parseInt(option);
			switch (choice) {
			case 1:

				AdminDao adminDao = Factory.getAdminDAOInstance();
				adminDao.listOfHotel();

				break;

			case 2:
				log.info("enter the hotel id to check");
				String hotelNo = sc.next();
				while (!inputValidations.hotelIdValidation(hotelNo)) {
					log.info("please enter valid hotelId");
					hotelNo = sc.next();
				}

				Integer hotelId = Integer.parseInt(hotelNo);

				AdminDao adminDao2 = Factory.getAdminDAOInstance();
				adminDao2.listofReservedRoomsofHotel(hotelId);
				break;

			case 3:
				log.info("enter the hotelId");
				String hotelNo1 = sc.next();
				while (!inputValidations.hotelIdValidation(hotelNo1)) {
					log.info("please enter valid hotelId");
					hotelNo1 = sc.next();
				}

				Integer hotelId1 = Integer.parseInt(hotelNo1);
				AdminDao adminDao3 = Factory.getAdminDAOInstance();
				adminDao3.basedOnGuest(hotelId1);
				break;
			case 4:
				log.info("enter the date");
				String date = sc.next();
				while (!inputValidations.dateValidation(date)) {
					log.info("please enter valid  date");
					date = sc.next();
				}

				LocalDate fromDate = LocalDate.parse(date);

				AdminDao adminDao4 = Factory.getAdminDAOInstance();
				adminDao4.basedOnDate(fromDate);

				break;
			case 5:
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
