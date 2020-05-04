package com.capgemini.hotelbookingapp.dao;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.services.AdminService;
import com.capgemini.hotelbookingapp.services.UserService;
import com.capgemini.hotelbookingapp.validations.InputValidations;

public class RoomCrudOperations {

	final Logger log = Logger.getLogger(UserService.class);

	InputValidations inputValidations = Factory.getInputValidationInstance();
	Scanner sc = new Scanner(System.in);

	public void roomCrudOperations() {
		log.info("\n--------------- Room  Operations ------------------");

		log.info("\nSelect the options below");
		do {
			log.info("1. Add Room ");
			log.info("2. Update Room");
			log.info("3. Delete room");
			log.info("4. Back");
			String option = sc.next();

			while (!inputValidations.choiceValidateRoom(option)) {
				log.info("please enter valid choice");
				option = sc.next();
			}

			Integer choice = Integer.parseInt(option);
			switch (choice) {
			case 1:

				AdminDao adminDao = Factory.getAdminDAOInstance();
				adminDao.addRooms();

				break;

			case 2:
				log.info("Enter Hotelid to update Room");
				String hotelNo = sc.next();
				while (!inputValidations.hotelIdValidation(hotelNo)) {
					log.info("please enter valid hotelId");
					hotelNo = sc.next();
				}

				int hotelId = Integer.parseInt(hotelNo);
				log.info("enter roomId to update");
				String roomNo = sc.next();
				while (!inputValidations.roomIdValidation(roomNo)) {
					log.info("please enter valid roomNo");
					roomNo = sc.next();
				}

				int roomId = Integer.parseInt(roomNo);

				AdminDao adminDao1 = Factory.getAdminDAOInstance();
				adminDao1.updateRoom(hotelId, roomId);
				break;

			case 3:
				log.info("enter the hotel id to delete room");
				String hotelNo1 = sc.next();
				while (!inputValidations.hotelIdValidation(hotelNo1)) {
					log.info("please enter valid hotelId");
					hotelNo1 = sc.next();
				}
				Integer hotelId1 = Integer.parseInt(hotelNo1);

				log.info("enter roomId to delete");
				String roomNo1 = sc.next();
				while (!inputValidations.roomIdValidation(roomNo1)) {
					log.info("please enter valid RoomNo");
					roomNo1 = sc.next();
				}
				Integer roomId1 = Integer.parseInt(roomNo1);

				AdminDao adminDao3 = Factory.getAdminDAOInstance();
				adminDao3.deleteRoom(hotelId1, roomId1);

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

	public String[] roomSpecificationSlelections() {

		log.info("Room Specifications");
		log.info("1.TV");
		log.info("2.WIFI");
		log.info("3.Parking");
		log.info("4.AC");

		log.info("Enter number of Specifications");
		String count = sc.next();
		while (!inputValidations.noOfSpecifiactionsValidation(count)) {
			log.info("please enter valid choice");
			count = sc.next();
		}
		int noOfSpecification = Integer.parseInt(count);

		String s[] = new String[noOfSpecification];
		log.info("enter the choices");
		for (int i = 1; i <= noOfSpecification; i++) {
			String option = sc.next();
			while (!inputValidations.specificationsChoiceValidation(option)) {
				log.info("please enter valid choice");
				option = sc.next();
			}
			int choice = Integer.parseInt(option);

			switch (choice) {
			case 1:
				s[i - 1] = "Tv";
				break;
			case 2:
				s[i - 1] = "Wifi";
				break;
			case 3:
				s[i - 1] = "Parking";
				break;
			case 4:
				s[i - 1] = "Ac";
				break;
			default:
				break;

			}

		}

		return s;

	}

	public String roomTypeSelection() {

		log.info("Room Types");
		log.info("1.Double Bed Room");
		log.info("2.Single Bed Room");
		log.info("enter choice of roomtype");
		String option = sc.nextLine();
		while (!inputValidations.choiceValidation(option)) {
			log.info("please enter valid choice");
			option = sc.next();
		}
		int choice = Integer.parseInt(option);
		String roomType = null;
		switch (choice) {
		case 1:
			roomType = "Double Bed Room";
			log.info("Double Bed room you have choosed");
			break;
		case 2:
			roomType = "Single Bed Room";
			log.info("Single Bed room you have choosed");

			break;
		default:
			log.info("enter valid choice ");
			break;
		}

		return roomType;

	}
}
