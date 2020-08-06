package com.raveen.parkingManagement;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        try{int n;
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("1.Login\n2.Setup Admin\n3.Exit");
                System.out.print("Enter your choice : ");
                n = scanner.nextInt();
                switch (n) {
                    case 1:
                        Login.login();
                        break;
                    case 2:
                        SetUser.setAdmin();
                        break;
                    case 3:
                        System.exit(0);
                }
            }

        }catch(Exception e){
                System.out.println("Something went wrong\n" + e);
        }
    }
}
