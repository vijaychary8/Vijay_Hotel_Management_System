package com.capgemini.hotelbookingapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.capgemini.hotelbookingapp.bean.CustomerBean;
import com.capgemini.hotelbookingapp.exceptions.EmailIdFoundException;
import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.validations.InputValidations;

import org.apache.log4j.Logger;

public class RegistrationDaoImp implements RegistrationDao {

	public static List<CustomerBean> CustomerList = new ArrayList<CustomerBean>();
	CustomerBean customerBean = Factory.getCustomerBeanInstance();
	InputValidations inputValidations = Factory.getInputValidationInstance();
	Scanner sc = new Scanner(System.in);

	static final Logger log = Logger.getLogger(RegistrationDaoImp.class);
	static {
		CustomerBean customerBean1 = Factory.getCustomerBeanInstance();
		customerBean1.setUserName("vijay");
		customerBean1.setMailId("vijaychary8@gmail.com");
		customerBean1.setMobileNo(9491381997l);
		customerBean1.setAge(22);
		customerBean1.setAddress("Kalimandir,Hyderabad");
		customerBean1.setAadharNo(123456789123l);
		customerBean1.setPassword("vijaychary8");
		CustomerList.add(customerBean1);

		CustomerBean customerBean2 = Factory.getCustomerBeanInstance();

		customerBean2.setUserName("vinay");
		customerBean2.setMailId("vinaychary13@gmail.com");
		customerBean2.setMobileNo(9441230597l);
		customerBean2.setAge(21);
		customerBean2.setAddress("Kalimandir,Hyderabad");
		customerBean2.setAadharNo(123456789456l);
		customerBean2.setPassword("vinaychary13");
		CustomerList.add(customerBean2);

	}

	@Override
	public boolean customerRegistration() {

		int count = 0;

		log.info("enter you name ");

		String userName = sc.nextLine();

		while (!inputValidations.customerNameValidation(userName)) {
			log.info("please enter valid name");
			userName = sc.nextLine();
		}

		log.info("Enter your mailId which must include '@'");
		String mailId = sc.next();
		while (!inputValidations.emailValidation(mailId)) {
			log.info("please enter valid mail");
			mailId = sc.next();
		}

		for (CustomerBean customerBean : CustomerList) {
			if (customerBean.getMailId().equals(mailId)) {
				count++;
			}
		}
		if (count == 0) {
			log.info("enter your age");
			String Age = sc.next();
			while (!inputValidations.ageValidation(Age)) {
				log.info("please enter valid format of age");
				Age = sc.next();
			}
			Integer age = Integer.parseInt(Age);

			log.info("enter your Mobile Number which starts with (6,7,8,9) and include 10 digits");
			String phoneNo = sc.next();
			while (!inputValidations.mobileNoValidation(phoneNo)) {
				log.info("please enter valid mobile no");
				phoneNo = sc.next();
			}
			Long mobileNo = Long.parseLong(phoneNo);

			log.info("enter your aadhar number must include 12 digits");
			String aadhar = sc.next();
			while (!inputValidations.aadharValidation(aadhar)) {
				log.info("please enter valid addhar number");
				aadhar = sc.next();
			}
			Long aadharNo = Long.parseLong(aadhar);

			log.info("enter your address in the form 'ho.no,Place'");
			String address = sc.next();
			while (!inputValidations.addressValidation(address)) {
				log.info("please enter valid Address");
				address = sc.next();
			}

			log.info("enter new password must include 10-15 characters");
			String password = sc.next();
			while (!inputValidations.passwordValidation(password)) {
				log.info("please enter valid password");
				password = sc.next();
			}

			customerBean.setUserName(userName);
			customerBean.setMailId(mailId);
			customerBean.setAge(age);
			customerBean.setMobileNo(mobileNo);
			customerBean.setAadharNo(aadharNo);
			customerBean.setAddress(address);
			customerBean.setPassword(password);
		}
		try {
			if (count == 1) {
				throw new EmailIdFoundException();
			} else {
				ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
				list.add(customerBean);
				CustomerList.addAll(list);
				log.info("Registered Successfully");
				return true;
			}
		} catch (EmailIdFoundException e) {
			log.info("Registration Failed....Email id is already Exist");
			return false;
		}

	}

	@Override
	public boolean printList() {
		for (CustomerBean customerBean : CustomerList) {
			System.out.format("%20s %20s %30s %20s %20s %30s %5s", customerBean.getUserName(),
					customerBean.getPassword(), customerBean.getMailId(), customerBean.getMobileNo(),
					customerBean.getAadharNo(), customerBean.getAddress(), customerBean.getAge());
			log.info("\n");

		}
		log.info(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");

		return false;

	}
}
