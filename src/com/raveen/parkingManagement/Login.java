package com.raveen.parkingManagement;

import java.util.Map;
import java.util.Scanner;



public class Login {
	public static void login() throws Exception{
		int userId=0;
		String password;
		Scanner scanner = new Scanner(System.in);
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
		for(Map.Entry m : Data.admin.entrySet()){
			if(m.getKey().equals(userId) && m.getValue().equals(password)){
				System.out.println("login successful!!");
				Admin.admin();
				return;
			}
		}
		for(Map.Entry m : Data.worker.entrySet()){
			if(m.getKey().equals(userId) && m.getValue().equals(password)){
				System.out.println("login successful!!");
				Worker.worker();
				return;
			}
		}
		System.out.println("No user found!!");

	}
}
