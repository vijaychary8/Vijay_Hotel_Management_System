package com.capgemini.hotelbookingapp.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbookingapp.bean.HotelBean;
import com.capgemini.hotelbookingapp.bean.Rooms;
import com.capgemini.hotelbookingapp.exceptions.HotelIdNotFoundException;
import com.capgemini.hotelbookingapp.exceptions.RoomHasBookedAlready;
import com.capgemini.hotelbookingapp.exceptions.RoomIdNotFoundException;
import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.services.UserService;
import com.capgemini.hotelbookingapp.validations.InputValidations;

public class UserDaoImp implements UserDao {
	static HashMap<HotelBean, ArrayList<Rooms>> map = new HashMap<HotelBean, ArrayList<Rooms>>();
	static ArrayList<HotelBean> hotelList = new ArrayList<HotelBean>();
	static ArrayList<Rooms> roomList1 = new ArrayList<Rooms>();
	static ArrayList<Rooms> roomList2 = new ArrayList<Rooms>();
	InputValidations inputValidations = Factory.getInputValidationInstance();
	static ArrayList<Rooms> bookingsStatusList = new ArrayList<Rooms>();
	UserService userService = Factory.getUserServiceInstance();
	static ArrayList<Rooms> bookedList = new ArrayList<Rooms>();

	final Logger log = Logger.getLogger(UserDaoImp.class);
	Scanner sc = new Scanner(System.in);

	static {

		HotelBean hotelBean1 = Factory.getHotelBeanInstance();
		ArrayList<HotelBean> list1 = new ArrayList<HotelBean>();
		String s[] = { "Ac", "tv", "freewifi", "geyser" };
		hotelBean1.setHotelId(01);
		hotelBean1.setHotelName("V3");
		hotelBean1.setHotelDetails("Five Star Hotel");

		hotelBean1.setHotelAddress("kalimandir,hyderabad");
		hotelBean1.setNoOfRooms(10);
		list1.add(hotelBean1);
		hotelList.addAll(list1);

		Rooms V3room1 = Factory.getRoomsInstance();
		V3room1.setHotelId(01);
		V3room1.setRoomNo(101);
		V3room1.setRoomType("Classic 2X");
		V3room1.setStatus("Available");
		V3room1.setFrom(null);
		V3room1.setTo(null);
		V3room1.setSpecifications(s);
		V3room1.setRoomCost(564);
		V3room1.setGuestName("null");

		ArrayList<Rooms> room1 = new ArrayList<Rooms>();
		room1.add(V3room1);

		roomList1.addAll(room1);

		Rooms V3room2 = Factory.getRoomsInstance();
		V3room2.setHotelId(01);
		V3room2.setRoomNo(102);
		V3room2.setRoomType("Deluxe(2X)");
		V3room2.setStatus("Reserved");
		V3room2.setFrom(LocalDate.of(2020, 04, 23));
		V3room2.setTo(LocalDate.of(2020, 04, 29));
		V3room2.setSpecifications(s);
		V3room2.setRoomCost(1000);
		V3room2.setGuestName("varun");
		ArrayList<Rooms> room2 = new ArrayList<Rooms>();
		room2.add(V3room2);
		bookingsStatusList.add(V3room2);
		roomList1.addAll(room2);
		map.put(hotelBean1, roomList1);

		HotelBean hotelBean2 = Factory.getHotelBeanInstance();
		ArrayList<HotelBean> list2 = new ArrayList<HotelBean>();
		String s1[] = { "Ac", "tv", "freewifi", "geyser" };
		hotelBean2.setHotelId(02);
		hotelBean2.setHotelName("oyo");
		hotelBean2.setHotelDetails("two star hotel");

		hotelBean2.setHotelAddress("LangarHouse,hyderabad");
		hotelBean2.setNoOfRooms(2);
		list2.add(hotelBean2);
		hotelList.addAll(list2);

		Rooms oyoroom3 = Factory.getRoomsInstance();
		oyoroom3.setHotelId(02);
		oyoroom3.setRoomNo(201);
		oyoroom3.setRoomType("Classic 2X");
		oyoroom3.setStatus("Reserved");
		oyoroom3.setFrom(LocalDate.of(2020, 04, 23));
		oyoroom3.setTo(LocalDate.of(2020, 04, 23));
		oyoroom3.setSpecifications(s1);
		oyoroom3.setRoomCost(564);
		oyoroom3.setGuestName("vijay");
		ArrayList<Rooms> room3 = new ArrayList<Rooms>();
		room3.add(oyoroom3);
		bookingsStatusList.add(oyoroom3);
		roomList2.addAll(room3);

		Rooms oyoroom4 = Factory.getRoomsInstance();
		oyoroom4.setHotelId(02);
		oyoroom4.setRoomNo(202);
		oyoroom4.setRoomType("Deluxe(2X)");
		oyoroom4.setStatus("Available");
		oyoroom4.setFrom(LocalDate.of(2020, 04, 23));
		oyoroom4.setTo(null);
		oyoroom4.setSpecifications(s1);
		oyoroom4.setRoomCost(1000);
		oyoroom4.setGuestName("null");
		ArrayList<Rooms> room4 = new ArrayList<Rooms>();
		room4.add(oyoroom4);
		roomList2.addAll(room4);
		map.put(hotelBean2, roomList2);

	}

	@Override
	public boolean selectHotel() {
		int count = 0;
		int flag = 0;
		int count1=0;
		log.info("List of hotels ");
		log.info((hotelList));
		log.info("Enter the Hotel Id which you want to choose ");
		String hotelno = sc.next();
		while (!inputValidations.hotelIdValidation(hotelno)) {
			log.info("please enter valid hotelId");
			hotelno = sc.next();
		}

		Integer hotelid = Integer.parseInt(hotelno);

		for (Map.Entry<HotelBean, ArrayList<Rooms>> x : map.entrySet()) {
			if (x.getKey().getHotelId() == hotelid) {
				flag++;
				ArrayList<Rooms> r = new ArrayList<Rooms>(x.getValue());
				log.info("\n List of rooms");

				log.info(r);
				log.info("Enter your RoomNo which you want to choose");

				String roomno = sc.next();
				while (!inputValidations.roomIdValidation(roomno)) {
					log.info("please enter valid roomId");
					roomno = sc.next();
				}

				Integer roomId = Integer.parseInt(roomno);

				for (Rooms roomSearch : r) {
					if (roomSearch.getRoomNo() == roomId && roomSearch.getStatus().equals("Available")
							&& roomSearch.getHotelId() == hotelid ) {
						count++;
						roomSearch.setStatus("Reserved");
						log.info("\n Enter your Name");
						sc.nextLine();
						String guestName = sc.nextLine();
						while (!inputValidations.customerNameValidation(guestName)) {
							log.info("please enter valid name");
							guestName = sc.nextLine();
						}

						roomSearch.setGuestName(guestName);
						LocalDate today = LocalDate.now();

						LocalDate FromDate = today.plus(1, ChronoUnit.DAYS);
						roomSearch.setFrom(FromDate);
						sc.nextLine();
						log.info("Enter how many days you want to stay");
						int days = sc.nextInt();
						LocalDate toDate = today.plus(days, ChronoUnit.DAYS);
						roomSearch.setTo(toDate);
						bookedList.add(roomSearch);
						bookingsStatusList.add(roomSearch);
						log.info("Room is  Booked");
						log.info(roomSearch);

					}

				}

			}

		}
		try {
			if (flag == 0) {
				throw new HotelIdNotFoundException();
			} else if (count == 0) {
				throw new RoomIdNotFoundException();
			} 
			else {
				return true;
			}
		} catch (HotelIdNotFoundException e) {
			log.info("  HotelId not found");
			return false;
		}catch(RoomIdNotFoundException b) {
			log.info("Room not found");
			return false;
		}
		

	}

	public List<Rooms> bookingsStatusList() {

		log.info(bookingsStatusList);
		return bookingsStatusList;

	}

	@Override
	public List<Rooms> statusList() {
		log.info(bookedList);
		return bookedList;
	}

	public void printList() {
		RegistrationDao daoRegistration = Factory.getRegistrationDAOInstance();

		log.info(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%20s %20s %30s %20s %20s %30s %5s", "USERNAME", "PASSWORD", "MAILID", "MOBILE-NO",
				"AADHAR-NO", "ADDRESS", "AGE");
		log.info(
				"\n-------------------------------------------------------------------------------------------------------------------------------------------------");
		log.info("\n");
		daoRegistration.printList();

	}

}
