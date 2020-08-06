package com.raveen.parkingManagement;

import java.util.Map;
import java.util.Scanner;

public class Admin {
	static Scanner scanner = new Scanner(System.in);
	public static void admin() throws Exception{
		int n;
		System.out.println("Welcome Admin!!");
		while (true) {
			System.out.println("1.Setup Parking\n" +
					"2.Setup Worker\n" +
					"3.Setup Premium customer\n" +
					"4.Availability\n" +
					"5.Report\n" +
					"6.Logout");
			System.out.print("Enter your choice : ");
			n = scanner.nextInt();
			switch (n) {
				case 1:
					setPark();
					break;
				case 2:
					setWorker();
					break;
				case 3:
					setPreCus();
					break;
				case 4:
					checkAvailability();
					break;
				case 5:
					generateReport();
					break;
				case 6:
					return;
				default:
					System.out.println("Enter a valid choice!!");
			}
		}
	}

	static void setPark(){
		int floor, noOfCarPerFloor;
		float amountPerHour;
		if(Data.spaceForPark != null) {
			System.out.println("\nPark is Already set\n");
		}else{
			System.out.print("Enter the no of floors in the building : ");
			floor = scanner.nextInt();
			Data.floors = floor;
			System.out.print("Enter the no of cars per floor : ");
			noOfCarPerFloor = scanner.nextInt();
			System.out.print("Enter the amount for an hour    RS: ");
			amountPerHour = scanner.nextInt();
			Data.spaceForPark = new int[floor][noOfCarPerFloor];
			Data.amount = amountPerHour / 3600000;
		}
	}

	static void setWorker()throws Exception{
		SetUser.setWorker();
	}

	static void setPreCus(){
		int flag = 0,noSlotFloors;
		String id;
		int[] slot = new int[2];
		noSlotFloors = slotCheck();
		if(noSlotFloors != Data.floors) {
			while (true) {
				System.out.print("Enter the floor : ");
				slot[0] = scanner.nextInt() - 1;
				System.out.print("Enter the slot : ");
				slot[1] = scanner.nextInt() - 1;
				scanner.nextLine();
				if (Data.spaceForPark[slot[0]][slot[1]] == 0 && Data.spaceForPark[slot[0]][slot[1]] != 2 ) {
					while (true) {
						System.out.print("Enter the ID for customer : ");
						id = scanner.nextLine();
						for (Map.Entry<String, int[]> m : Data.preCus.entrySet()) {
							if (m.getKey().equals(id)) {
								System.out.println("ID already exist!!");
								flag = 1;
								break;
							}
						}
						if (flag == 1) {
							flag = 0;
							continue;
						} else {
							Data.spaceForPark[slot[0]][slot[1]] = 2;
							Data.preCus.put(id, slot);
							break;
						}
					}
					break;
				} else {
					System.out.println("That Slot is full now...Try some other slot");
					continue;
				}
			}
		}else{
			System.out.println("All slots are full....Try again later");
			return;
		}
	}

	static void checkAvailability(){
		try {
			int n;
			while (true) {
				System.out.print("1.Check number of slot available of parking\n" +
						"2.Check the slots which are available for parking\n" +
						"3.Exit\n" +
						"Enter your choice : ");
				n = scanner.nextInt();
				switch (n) {
					case 1:
						int freeSlots = 0;
						for (int i = 0; i < Data.spaceForPark.length; i++) {
							for (int j = 0; j < Data.spaceForPark[0].length; j++) {
								if (Data.spaceForPark[i][j] == 0) {
									freeSlots++;
								}
							}
						}
						System.out.println("Free slots available are " + freeSlots);
						break;

					case 2:
						slotCheck();
						break;
					case 3:
						return;
					default:
						System.out.println("Enter a valid Choice!!");
				}
			}
		}catch(Exception e){
			System.out.print("You have to setup Park for parking first!!");
			return;
		}
	}

	static void generateReport(){
		if(Data.spaceForPark != null){
			System.out.println("Park Details : ");
			System.out.println("\tFloors : " + Data.spaceForPark.length + "\tSlot : " + Data.spaceForPark[0].length);
			System.out.println("\tAmount per hour for parking : Rs." + (Data.amount * 3600000));
			System.out.println();
		}else{
			System.out.println("\nSet up the park\n");
		}
		if(Data.admin.size() != 0){
			System.out.println("Admin Details : ");
			for(Map.Entry<Integer, String> m: Data.admin.entrySet()){
				System.out.println("\tAdmin ID : " + m.getKey());
				System.out.println("\tPassword : " + m.getValue());
				System.out.println("");
			}
		}
		if(Data.worker.size() != 0){
			System.out.println("Worker Details : ");
			for(Map.Entry<Integer, String> m: Data.worker.entrySet()){
				System.out.println("\tWorker ID : " + m.getKey());
				System.out.println("\tPassword : " + m.getValue());
				System.out.println("");
			}
		}else{
			System.out.println("No Workers has been set\n");
		}
		if(Data.preCus.size() != 0){
			System.out.println("Premium Customer Details : ");
			for(Map.Entry<String, int[]> m: Data.preCus.entrySet()){
				System.out.println("\tPremium Customer ID : " + m.getKey());
				System.out.println("\t\tFloor : " + (m.getValue()[0]+1) + "\tSlot : " + (m.getValue()[1]+1));
				System.out.println("");
			}
		}else{
			System.out.println("No Premium Customer has been set\n");
		}
		if(!Data.report.isEmpty()){
			System.out.println("Report:");
			for(ReportData rd: Data.report){
				System.out.println("\tVehicle ID : " + rd.id);
				System.out.println("\t\tFloor : " + (rd.floor + 1) + "\tSlot : " + (rd.slot + 1));
				System.out.println("\t\tCheck-in Time : " + rd.inTime);
				System.out.println("\t\tCheck-out Time : " + rd.outTime);
				System.out.println("\t\tTotal parking time : " + rd.hours + " hrs " + rd.mins + " mins " + rd.secs + " secs ");
				System.out.println("\t\tAmount Paid : Rs." + rd.amount);
			}
			System.out.println("\t\t\t\tTotal Amount Collected : Rs." + Data.totalAmount);
		}else{
			System.out.println("No data to produce Check-out Report.....Wait for someone to check out\n");
		}
	}

	static int slotCheck(){
		int flag = 0;
		int noSlotFloors = 0;
		System.out.println("Slots available : ");
		for (int i = 0; i < Data.spaceForPark.length; i++) {
			System.out.println("\tFloor : " + (i+1));
			for (int j = 0; j < Data.spaceForPark[0].length; j++) {
				if (Data.spaceForPark[i][j] == 0) {
					System.out.println("\t\tSlot : " + (j+1));
					flag = 1;
				}
			}
			if (flag == 0) {
				System.out.println("\t\tNo Slot Available!!");
				noSlotFloors++;
			}
			flag = 0;
		}
		return noSlotFloors;
	}

}
