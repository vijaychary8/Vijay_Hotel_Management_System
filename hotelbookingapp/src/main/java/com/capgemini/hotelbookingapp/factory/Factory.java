package com.capgemini.hotelbookingapp.factory;

import com.capgemini.hotelbookingapp.bean.CustomerBean;
import com.capgemini.hotelbookingapp.bean.HotelBean;
import com.capgemini.hotelbookingapp.bean.Rooms;
import com.capgemini.hotelbookingapp.dao.AdminDao;
import com.capgemini.hotelbookingapp.dao.AdminDaoImp;
import com.capgemini.hotelbookingapp.dao.HotelCrudOperations;
import com.capgemini.hotelbookingapp.dao.RegistrationDao;
import com.capgemini.hotelbookingapp.dao.RegistrationDaoImp;
import com.capgemini.hotelbookingapp.dao.Report;
import com.capgemini.hotelbookingapp.dao.RoomCrudOperations;
import com.capgemini.hotelbookingapp.dao.UserDao;
import com.capgemini.hotelbookingapp.dao.UserDaoImp;
import com.capgemini.hotelbookingapp.services.AdminService;
import com.capgemini.hotelbookingapp.services.HotelManagementService;
import com.capgemini.hotelbookingapp.services.RegisterService;
import com.capgemini.hotelbookingapp.services.UserService;
import com.capgemini.hotelbookingapp.validations.InputValidations;
import com.capgemini.hotelbookingapp.validations.InputValidationsImp;

public class Factory {

	public static CustomerBean getCustomerBeanInstance() {
		CustomerBean customerBean = new CustomerBean();
		return customerBean;
	}

	public static RegistrationDao getRegistrationDAOInstance() {
		RegistrationDao registrationDao = new RegistrationDaoImp();
		return registrationDao;
	}

	public static AdminDao getAdminDAOInstance() {
		AdminDao adminDao = new AdminDaoImp();
		return adminDao;
	}

	public static HotelCrudOperations getHotelCrudDAOInstance() {
		HotelCrudOperations hotelCrudOperations = new HotelCrudOperations();
		return hotelCrudOperations;
	}

	public static RoomCrudOperations getRoomCrudDAOInstance() {
		RoomCrudOperations roomCrudOperations = new RoomCrudOperations();
		return roomCrudOperations;
	}

	public static Report getReportInstance() {
		Report report = new Report();
		return report;
	}

	public static RegisterService getRegisterServiceInstance() {
		RegisterService registerService = new RegisterService();
		return registerService;
	}

	public static InputValidations getInputValidationInstance() {

		return new InputValidationsImp();
	}

	public static UserService getUserServiceInstance() {
		UserService userService = new UserService();
		return userService;
	}

	public static AdminService getAdminServiceInstance() {
		AdminService adminService = new AdminService();
		return adminService;
	}

	public static HotelManagementService getHotelManagementServiceInstance() {
		HotelManagementService hotelManagementService = new HotelManagementService();
		return hotelManagementService;
	}

	public static HotelBean getHotelBeanInstance() {
		HotelBean hotelBean = new HotelBean();
		return hotelBean;
	}

	public static Rooms getRoomsInstance() {
		Rooms rooms = new Rooms();
		return rooms;
	}

	public static UserDao getUserDAOInstance() {
		UserDao userDao = new UserDaoImp();
		return userDao;
	}
}
