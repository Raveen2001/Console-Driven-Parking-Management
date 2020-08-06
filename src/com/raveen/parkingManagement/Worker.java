package com.raveen.parkingManagement;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Worker {
	static Date inTime;
	static Date outTime;
	static long timeInPark;
	static Scanner scanner = new Scanner(System.in);
	public static void worker() throws Exception{
		int n;
		System.out.println("Welcome Worker!!");
		while(true) {
			System.out.print("1.Make a parking\n" +
					"2.Make a check-out\n" +
					"3.Check Availability\n" +
					"4.Logout\nEnter your choice : ");
			n = scanner.nextInt();
			switch(n){
				case 1:
					try {
						MakeParking();
					}catch (Exception e){
						System.out.println("Create park for parking first\n\n");
					}
					break;
				case 2:
					try {
						MakeCheckOut();
					}catch(Exception e){
						System.out.println("Create park for parking first");
					}
					break;
				case 3:
					Admin.checkAvailability();
					break;
				case 4:
					return;
				default:
					System.out.println("Enter a valid choice!!");
			}
		}
	}

	static void MakeParking(){
		String id;
		int floor, slot;
		int flag = 0, n;
		while (true) {
			System.out.println("1.Premium Customer\n2.Vehicle Number\n3.exit");
			System.out.print("Enter your choice : ");
			n = scanner.nextInt();
			scanner.nextLine();
			switch (n) {
				case 1:
					System.out.print("Enter the Customer ID : ");
					id = scanner.nextLine();
					for (Map.Entry<String, int[]> m : Data.preCus.entrySet()) {
						if (m.getKey().equals(id)) {
							floor = m.getValue()[0];
							slot = m.getValue()[1];
							if (Data.spaceForPark[floor][slot] == 2) {
								Data.spaceForPark[floor][slot] = 1;
								Data.parkingIds.add(id);
								inTime = new Date();
								Data.checkInData.put(id, new Date[]{inTime, null});
								Data.slotsData.put(id, new int[]{floor, slot});
								System.out.println("Vehicle parked!!");
								System.out.println("Check-in Time : " + inTime);
								flag = 1;
								break;
							} else {
								System.out.println("Some Vehicle is already parked in your slot...try contacting admin for making more slot for you");
								flag = 1;
								break;
							}
						}
					}
					if (flag == 0) {
						System.out.println("There is no such Premium ID...Try contacting Admin for making a slot for you");
					}
					flag = 0;
					break;
				case 2:
					if(!(Admin.slotCheck() == Data.floors)) {
						System.out.print("Enter the Vehicle Number : ");
						id = scanner.nextLine();
						if (!Data.parkingIds.contains(id)) {
							Admin.slotCheck();
							while (true) {
								System.out.print("Enter the floor : ");
								floor = scanner.nextInt() - 1;
								System.out.print("Enter the slot : ");
								slot = scanner.nextInt() - 1;
								if (Data.spaceForPark[floor][slot] == 0 && !(Data.spaceForPark[floor][slot] == 2)) {
									Data.spaceForPark[floor][slot] = 1;
									Data.parkingIds.add(id);
									inTime = new Date();
									Data.checkInData.put(id, new Date[]{inTime, null});
									Data.slotsData.put(id, new int[]{floor, slot});
									System.out.println("Vehicle Parked...");
									System.out.println("Check-in Time : " + inTime);
									break;
								} else {
									System.out.println("Slot is already taken...try some other slot");
									continue;
								}
							}
						} else {
							System.out.println("Vehicle with same number Parked!!");
						}
					}else{
						System.out.println("No slots available...come again later!!");
						return;
					}
					break;
				case 3:
					return;
				default:
					System.out.println("Enter a valid Choice!!");
			}
		}
	}


	static void MakeCheckOut(){
		String id;
		int n;
		int floor, slot;
		long diffSeconds, diffMinutes, diffHours;
		boolean noUser = true;
		ReportData rd;
		while(true){
			System.out.print("1.Premium Customer\n2.Vehicle Number\n3.Vehicles in Park\n4.Exit\nEnter your choice : ");
			n = scanner.nextInt();
			scanner.nextLine();
			switch(n){
				case 1:
					noUser = true;
					if(!checkParkPre()) {
						while (true) {
							rd = new ReportData();
							System.out.print("Enter the ID : ");
							id = scanner.nextLine();
							for (String s : Data.parkingIds) {
								if(id.equals(s) && Data.preCus.containsKey(s)) {
									outTime = new Date();
									System.out.println("Bill Details : ");
									System.out.println("\tID : " + id);
									rd.id = id;
									for (Map.Entry<String, int[]> m : Data.slotsData.entrySet()) {
										if (id.equals(m.getKey())) {
											floor = m.getValue()[0];
											slot = m.getValue()[1];
											System.out.println("\tFloor : " + (floor + 1) + "\tSlot : " + (slot + 1));
											Data.spaceForPark[floor][slot] = 2;
											rd.floor = floor;
											rd.slot = slot;
										}
									}
									for (Map.Entry<String, Date[]> m : Data.checkInData.entrySet()) {
										if (id.equals(m.getKey())) {
											inTime = m.getValue()[0];
											timeInPark = outTime.getTime() - inTime.getTime();
											diffSeconds = timeInPark / 1000 % 60;
											diffMinutes = timeInPark / (60 * 1000) % 60;
											diffHours = timeInPark / (60 * 60 * 1000);
											System.out.println("\tCheck-in Time : " + inTime);
											System.out.println("\tCheck-out Time : " + outTime);
											System.out.println("\tTotal parking time : " + diffHours + " hrs " + diffMinutes + " mins " + diffSeconds + " secs ");
											rd.inTime = inTime;
											rd.outTime = outTime;
											rd.hours = diffHours;
											rd.mins = diffMinutes;
											rd.secs = diffSeconds;
											rd.amount = timeInPark * Data.amount;
											Data.totalAmount += rd.amount;
											Data.report.add(rd);
											System.out.println("\tAmount : Rs" + rd.amount);

										}
									}
									Data.parkingIds.remove(id);
									Data.slotsData.remove(id);
									Data.checkInData.remove(id);
									noUser = false;
									break;
								}

							}
							if(noUser){
								System.out.println("No Vehicle Parked with that ID....");
								break;
							}
							noUser = true;
							break;
						}
					}else{
						System.out.println("No Vehicle in Park..");
					}
					break;
				case 2:
					noUser = true;
					if(!checkParkNor()) {
						while (true) {
							rd = new ReportData();
							System.out.print("Enter the Vehicle Number : ");
							id = scanner.nextLine();
							for (String s : Data.parkingIds) {
								if (id.equals(s) && !Data.preCus.containsKey(s)) {
									outTime = new Date();
									System.out.println("Bill Details : ");
									System.out.println("\tID : " + id);
									rd.id = id;
									for (Map.Entry<String, int[]> m : Data.slotsData.entrySet()) {
										if (id.equals(m.getKey())) {
											floor = m.getValue()[0];
											slot = m.getValue()[1];
											System.out.println("\tFloor : " + (floor + 1) + "\tSlot : " + (slot + 1));
											Data.spaceForPark[floor][slot] = 0;
											rd.floor = floor;
											rd.slot = slot;
										}
									}
									for (Map.Entry<String, Date[]> m : Data.checkInData.entrySet()) {
										if (id.equals(m.getKey())) {
											inTime = m.getValue()[0];
											timeInPark = outTime.getTime() - inTime.getTime();
											diffSeconds = timeInPark / 1000 % 60;
											diffMinutes = timeInPark / (60 * 1000) % 60;
											diffHours = timeInPark / (60 * 60 * 1000);
											System.out.println("\tCheck-in Time : " + inTime);
											System.out.println("\tCheck-out Time : " + outTime);
											System.out.println("Total parking time : " + diffHours + " hrs " + diffMinutes + " mins " + diffSeconds + " secs ");
											rd.inTime = inTime;
											rd.outTime = outTime;
											rd.hours = diffHours;
											rd.mins = diffMinutes;
											rd.secs = diffSeconds;
											rd.amount = timeInPark * Data.amount;
											Data.totalAmount += rd.amount;
											Data.report.add(rd);
											System.out.println("\tAmount : Rs" + rd.amount);
										}
									}
									Data.parkingIds.remove(id);
									Data.slotsData.remove(id);
									Data.checkInData.remove(id);
									noUser = false;
									break;
								}
							}
							if(noUser){
								System.out.println("No Vehicle Parked with that ID....");
								continue;
							}
							noUser = true;
							break;
						}
					}else{
						System.out.println("No vehicle in Park..");
					}
					break;
				case 3:
					checkPark();
					break;
				case 4:
					return;
				default:
					System.out.println("Enter a valid choice!!");
			}
		}
	}
	static void checkPark(){
		checkParkPre();
		checkParkNor();
	}

	static boolean checkParkPre(){
		boolean noVehicle = true;
		System.out.println("Premium Customer Details : ");
		for(String s: Data.parkingIds){
			if(Data.preCus.containsKey(s)) {
				System.out.println("\tCar ID : " + s);
				System.out.print("\t\tFloor : " + (Data.slotsData.get(s)[0] + 1));
				System.out.println("\tslot : " + (Data.slotsData.get(s)[1] + 1));
				noVehicle = false;
			}
		}
		if(noVehicle){
			System.out.println("\tNo Premium customer Vehicle in park");
		}
		return noVehicle;
	}

	static boolean checkParkNor(){
		boolean noVehicle = true;
		System.out.println("Normal Customer Details : ");
		for(String s: Data.parkingIds){
			if(!Data.preCus.containsKey(s)) {
				System.out.println("\tCar ID : " + s);
				System.out.print("\t\tFloor : " + (Data.slotsData.get(s)[0] + 1));
				System.out.println("\tslot : " + (Data.slotsData.get(s)[1] + 1));
				noVehicle = false;
			}
		}
		if(noVehicle){
			System.out.println("\tNo Normal customer Vehicle in park");
		}
		return noVehicle;
	}

	static void viewData(){
		System.out.println("Data : ");
		for(int i=0; i<Data.parkingIds.size();i++){
			System.out.println("id : " + Data.parkingIds.get(i));
			System.out.println("Time: ");
			for(Map.Entry<String, Date[]> m: Data.checkInData.entrySet()){
				System.out.println(m.getValue()[0]+ "," +m.getValue()[1]);
			}
		}
	}
}

