package com.capgemini.hotelbookingapp.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.capgemini.hotelbookingapp.bean.HotelBean;
import com.capgemini.hotelbookingapp.bean.Rooms;
import com.capgemini.hotelbookingapp.factory.Factory;
import com.capgemini.hotelbookingapp.services.UserService;
import com.capgemini.hotelbookingapp.validations.InputValidations;
import com.capgemini.hotelbookingapp.dao.UserDaoImp;
import com.capgemini.hotelbookingapp.exceptions.DateNotFoundException;
import com.capgemini.hotelbookingapp.exceptions.HotelIdMatchedInList;
import com.capgemini.hotelbookingapp.exceptions.HotelIdNotFoundException;
import com.capgemini.hotelbookingapp.exceptions.RoomIdMatchedInList;
import com.capgemini.hotelbookingapp.exceptions.RoomIdNotFoundException;

public class AdminDaoImp implements AdminDao {
	final Logger log = Logger.getLogger(UserService.class);
	ArrayList<HotelBean> hotelAddList = new ArrayList<HotelBean>();
	Scanner sc = new Scanner(System.in);
	InputValidations inputValidations = Factory.getInputValidationInstance();
	RoomCrudOperations roomCrudOperations = Factory.getRoomCrudDAOInstance();

	@Override
	public boolean addHotel() {
		int count = 0;
		HotelBean hotelBean = Factory.getHotelBeanInstance();
		int size1 = UserDaoImp.map.size();
		log.info("Size=" + size1);
		int size2;
		sc.nextLine();

		log.info("Enter hotel Id");
		String hotelNo = sc.nextLine();
		while (!inputValidations.hotelIdValidation(hotelNo)) {
			log.info("please enter valid HotelId");
			hotelNo = sc.nextLine();
		}

		Integer hotelId = Integer.parseInt(hotelNo);
		for (Map.Entry<HotelBean, ArrayList<Rooms>> x : UserDaoImp.map.entrySet()) {

			HotelBean hotelList = x.getKey();
			if (hotelList.getHotelId() == hotelId) {
				count++;
			}
		}
		if (count == 0) {
			log.info("enter hotel name");

			String hotelName = sc.nextLine();
			while (!inputValidations.nameValidation(hotelName)) {
				log.info("please enter Hotel name");
				hotelName = sc.nextLine();
			}
			log.info("Enter new hotelAddress in format 'RoadNo,street,place'");
			String hotelAddress = sc.nextLine();
			while (!inputValidations.addressValidation(hotelAddress)) {
				log.info("please enter valid Address");
				hotelAddress = sc.next();
			}
			log.info("Enter hotel Details(ex:five star hotel(small letters))");
			String hotelDetails = sc.nextLine();
			while (!inputValidations.hotelDetailsValidations(hotelDetails)) {
				log.info("please enter valid Details");
				hotelDetails = sc.next();
			}

			hotelBean.setHotelId(hotelId);
			hotelBean.setHotelName(hotelName);
			hotelBean.setHotelAddress(hotelAddress);
			hotelBean.setHotelDetails(hotelDetails);
			hotelBean.setNoOfRooms(0);
		}

		try {
			if (count == 1) {
				throw new HotelIdMatchedInList();
			} else {
				UserDaoImp.map.put(hotelBean, new ArrayList<Rooms>());
				log.info(UserDaoImp.map);
				size2 = UserDaoImp.map.size();
				log.info("Size=" + size2);
				log.info("Hotel is Added");
				return true;
			}
		} catch (HotelIdMatchedInList e) {
			log.info("HotelId is Already exist. Please change the HotelId ");
			return false;
		}

	}

	@Override
	public boolean updateHotel() {
		log.info("\n------------Update hotel------------------------");
		int count = 0;
		log.info("Enter HotelId for update");
		String hotelNo = sc.next();
		while (!inputValidations.hotelIdValidation(hotelNo)) {
			log.info("please enter valid HotelID");
			hotelNo = sc.next();
		}

		Integer hotelId = Integer.parseInt(hotelNo);
		for (Map.Entry<HotelBean, ArrayList<Rooms>> x : UserDaoImp.map.entrySet()) {

			HotelBean hotelList = x.getKey();
			if (hotelList.getHotelId() == hotelId) {
				count++;
				sc.nextLine();
				hotelList.setHotelId(hotelId);

				log.info("enter new hotel name");
				String hotelName = sc.nextLine();
				while (!inputValidations.nameValidation(hotelName)) {
					log.info("please enter valid HotelName");
					hotelName = sc.nextLine();
				}

				hotelList.setHotelName(hotelName);

				log.info("Enter new hotelAddress in format 'RoadNo,street,place'");
				String hotelAddress = sc.nextLine();
				while (!inputValidations.addressValidation(hotelAddress)) {
					log.info("please enter valid Address");
					hotelAddress = sc.next();
				}
				hotelList.setHotelAddress(hotelAddress);

				log.info("Enter new hotel Details (ex: five star hotel) in small letters");
				String hotelDetails = sc.nextLine();
				while (!inputValidations.hotelDetailsValidations(hotelDetails)) {
					log.info("please enter valid Details");
					hotelDetails = sc.next();
				}
				hotelList.setHotelDetails(hotelDetails);
				log.info("Enter room count (allows only two digit numbers)");
				String roomCount = sc.nextLine();
				while (!inputValidations.noOfRoomsValidations(roomCount)) {
					log.info("please enter valid Count");
					roomCount = sc.nextLine();
				}

				Integer noOfRooms = Integer.parseInt(roomCount);

				hotelList.setNoOfRooms(noOfRooms);

			}
		}
		try {
			if (count == 0) {
				throw new HotelIdNotFoundException();
			} else {
				log.info("Hotel updated");
				log.info(UserDaoImp.map);
				return true;
			}
		} catch (HotelIdNotFoundException e) {
			log.info("HotelId not found");
			return false;

		}

	}

	@Override
	public boolean deleteHotel(int hotelId) {
		int count = 0;
		for (Map.Entry<HotelBean, ArrayList<Rooms>> x : UserDaoImp.map.entrySet()) {
			HotelBean hotelList = x.getKey();
			if (hotelList.getHotelId() == hotelId) {
				count++;
				UserDaoImp.map.remove(hotelList, x.getValue());
				log.info("hotel is deleted .....");
			}

		}
		try {
			if (count == 0) {
				throw new HotelIdNotFoundException();
			} else {
				log.info(UserDaoImp.map);
				return true;
			}
		} catch (HotelIdNotFoundException e) {
			log.info("hotel Id not found");
			return false;

		}

	}

	@Override
	public boolean addRooms() {
		int size1 = 0;
		int size2 = 0;
		int flag = 0;
		int count1 = 0;
		log.info("Enter HotelId to add Room ");
		String hotelNo = sc.next();
		while (!inputValidations.hotelIdValidation(hotelNo)) {
			log.info("please enter valid hotelID");
			hotelNo = sc.next();
		}

		Integer hotelId = Integer.parseInt(hotelNo);
		for (Map.Entry<HotelBean, ArrayList<Rooms>> x : UserDaoImp.map.entrySet()) {
			HotelBean hotelBean1 = x.getKey();
			int count = x.getKey().getNoOfRooms();
			if (hotelBean1.getHotelId() == hotelId) {
				count1++;
				if (count1 == 0) {
					log.info(x.getKey());
					size1 = x.getValue().size();
					log.info("size=" + size1);
					sc.nextLine();
					log.info("Enter RoomId");
					String roomId = sc.nextLine();
					while (!inputValidations.roomIdValidation(roomId)) {
						log.info("please enter valid roomId");
						roomId = sc.nextLine();
					}

					Integer roomNo = Integer.parseInt(roomId);
					ArrayList<Rooms> roolList = new ArrayList<Rooms>(x.getValue());
					for (Rooms rooms : roolList) {
						if (rooms.getRoomNo() == (roomNo)) {
							flag++;

						}
					}
					String roomType = roomCrudOperations.roomTypeSelection();
					String status = "Available";

					LocalDate fromDate = null;
					LocalDate toDate = null;
					String specifications[] = roomCrudOperations.roomSpecificationSlelections();
					String guestName = "null";
					log.info("Enter the cost of Room ");
					String roomRent = sc.nextLine();
					while (!inputValidations.roomCostValidation(roomRent)) {
						log.info("please enter valid Room cost");
						roomRent = sc.nextLine();
					}
					double roomCost = Double.parseDouble(roomRent);
					Rooms rooms = Factory.getRoomsInstance();
					rooms.setRoomNo(roomNo);
					rooms.setHotelId(hotelId);
					rooms.setRoomType(roomType);
					rooms.setStatus(status);
					rooms.setFrom(fromDate);
					rooms.setTo(toDate);
					rooms.setSpecifications(specifications);
					rooms.setGuestName(guestName);
					rooms.setRoomCost(roomCost);
					if (flag == 0) {
						ArrayList<Rooms> roomAdd = new ArrayList<Rooms>(UserDaoImp.map.get(hotelBean1));
						roomAdd.add(rooms);
						UserDaoImp.map.put(hotelBean1, roomAdd);
						size2 = x.getValue().size();
						log.info("size=" + size2);
						count++;
						hotelBean1.setNoOfRooms(count);
					}
				}
			}
		}
		log.info(UserDaoImp.map);
		try {
			if (count1 == 0) {
				throw new HotelIdNotFoundException();
			} else if (flag == 1) {
				throw new RoomIdMatchedInList();
			} else {

				log.info("room is added");
				return true;
			}
		} catch (HotelIdNotFoundException b) {
			log.info("HotelId not found");
			return false;
		} catch (RoomIdMatchedInList e) {
			log.info("RoomId is already exist");
			return false;
		}

	}

	@Override
	public boolean updateRoom(int hotelId, int roomId) {
		int count = 0;
		int flag = 0;
		for (Map.Entry<HotelBean, ArrayList<Rooms>> x : UserDaoImp.map.entrySet()) {
			HotelBean hotelBean1 = x.getKey();

			if (hotelBean1.getHotelId() == hotelId) {
				flag++;
				ArrayList<Rooms> roomUpdate = new ArrayList<Rooms>(x.getValue());
				for (Rooms rooms : roomUpdate) {
					if (rooms.getRoomNo() == roomId && rooms.getHotelId() == hotelId) {

						count++;
						log.info("Enter Updated details");
						sc.nextLine();
						String roomType = roomCrudOperations.roomTypeSelection();

						LocalDate fromDate = null;
						LocalDate toDate = null;
						String specifications[] = roomCrudOperations.roomSpecificationSlelections();

						String guestName = "null";
						log.info("Enter the cost of Room");
						String roomRent = sc.nextLine();
						while (!inputValidations.roomCostValidation(roomRent)) {
							log.info("please enter valid RoomCost");
							roomRent = sc.nextLine();
						}
						double roomCost = Double.parseDouble(roomRent);

						rooms.setRoomNo(roomId);
						rooms.setRoomType(roomType);
						rooms.setStatus("Available");
						rooms.setFrom(fromDate);
						rooms.setTo(toDate);
						rooms.setSpecifications(specifications);
						rooms.setGuestName(guestName);
						rooms.setRoomCost(roomCost);

					}
				}

			}
		}
		try {
			if (flag == 0) {
				throw new HotelIdNotFoundException();
			} else if (count == 0) {
				throw new RoomIdNotFoundException();
			} else {
				log.info("Room updated");
				log.info(UserDaoImp.map);
				return true;
			}
		} catch (HotelIdNotFoundException b) {
			log.info("Hotel not found");
			return false;
		} catch (RoomIdNotFoundException e) {
			log.info("RoomId not found");
			return false;

		}
	}

	@Override
	public boolean deleteRoom(int hotelId, int roomId) {
		int count = 0;
		int flag = 0;

		for (Map.Entry<HotelBean, ArrayList<Rooms>> x : UserDaoImp.map.entrySet()) {
			HotelBean hotelBean1 = x.getKey();
			int roomCount = x.getKey().getNoOfRooms();

			if (hotelBean1.getHotelId() == hotelId) {
				flag++;

				ArrayList<Rooms> roomDelete = new ArrayList<Rooms>(x.getValue());
				for (Rooms rooms : roomDelete) {
					if (rooms.getRoomNo() == roomId && rooms.getHotelId() == hotelId) {
						count++;
						log.info(rooms.getRoomNo());
						x.getValue().remove(rooms);
						log.info("Room Deleted....");
						roomCount--;
						hotelBean1.setNoOfRooms(roomCount);
					}
				}
			}
		}
		try {
			if (flag == 0) {
				throw new HotelIdNotFoundException();
			} else if (count == 0) {
				throw new RoomIdNotFoundException();
			} else {
				log.info(UserDaoImp.map);
				return true;
			}
		} catch (HotelIdNotFoundException e) {
			log.info("  hotel  not found");
			return false;

		} catch (RoomIdNotFoundException d) {
			log.info("Room not found");
			return false;

		}
	}

	@Override
	public boolean listOfHotel() {
		log.info(UserDaoImp.map.keySet());
		return true;
	}

	@Override
	public boolean listofReservedRoomsofHotel(int hotelId) {
		int count = 0;
		int flag = 0;
		for (Map.Entry<HotelBean, ArrayList<Rooms>> x : UserDaoImp.map.entrySet()) {
			HotelBean hotelBean = x.getKey();
			if (hotelBean.getHotelId() == (hotelId)) {
				ArrayList<Rooms> rooms = new ArrayList<Rooms>(x.getValue());
				for (Rooms rooms2 : rooms) {
					if (rooms2.getStatus() == "Reserved" && rooms2.getHotelId() == hotelId) {
						flag++;
						count++;
						log.info(rooms2);
					}
				}
				if (count == 0) {
					log.info("no rooms Reserved for this hotel");
				}

			}
		}
		try {
			if (flag == 0) {
				throw new RoomIdNotFoundException();
			} else {
				return true;
			}
		} catch (RoomIdNotFoundException e) {
			log.info("hotelId not found");
		}

		return false;
	}

	@Override
	public boolean basedOnGuest(int hotelId) {
		int count = 0;
		ArrayList<String> guestNames = new ArrayList<String>();
		for (Map.Entry<HotelBean, ArrayList<Rooms>> x : UserDaoImp.map.entrySet()) {
			HotelBean hotelBean = x.getKey();
			if (hotelBean.getHotelId() == (hotelId)) {
				ArrayList<Rooms> rooms = new ArrayList<Rooms>(x.getValue());
				for (Rooms rooms2 : rooms) {
					if (rooms2.getStatus() == "Reserved" && rooms2.getHotelId() == hotelId) {
						count++;
						log.info(rooms2);
						String guestname = rooms2.getGuestName();
						guestNames.add(guestname);

					}
				}

			}
		}
		try {
			if (count == 0) {
				throw new HotelIdNotFoundException();
			} else {
				log.info(guestNames);
				return true;
			}
		} catch (HotelIdNotFoundException e) {
			log.info("HotelId not found");
		}

		return false;

	}

	@Override
	public boolean basedOnDate(LocalDate bookedDate) {
		int count = 0;
		for (Rooms room : UserDaoImp.bookingsStatusList) {
			if (room.getFrom().equals(bookedDate)) {
				count++;
				log.info(room);
			}
		}
		try {
			if (count == 0) {
				throw new DateNotFoundException();
			} else {
				return true;
			}
		} catch (DateNotFoundException e) {
			log.info("Date not found");
			return false;
		}
	}

}
