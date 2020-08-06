package com.raveen.parkingManagement;

import java.util.Scanner;

public class SetUser{
	static int userId;
	static String password;
	static Scanner scanner = new Scanner(System.in);

	public static void setAdmin() throws Exception{
		set();
		Data.admin.put(userId, password);
	}

	public static void setWorker() throws Exception{
		set();
		Data.worker.put(userId, password);
	}

	static void set(){
		while (true) {
			System.out.print("Enter the UserId : ");
			try {
				userId = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("UserId can only be numbers..Try again!!");
				scanner.nextLine();
				continue;
			}
			System.out.print("Enter the password : ");
			password = scanner.nextLine();
			break;
		}
	}
}
