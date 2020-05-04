package com.capgemini.hotelbookingapp.services;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingapp.dao.RegistrationDao;
import com.capgemini.hotelbookingapp.factory.Factory;

public class RegisterService {
	static Logger log = Logger.getLogger(RegisterService.class);
	RegistrationDao daoRegistration = Factory.getRegistrationDAOInstance();

	public boolean registerService() {

		daoRegistration.customerRegistration();

		return true;
	}

}
