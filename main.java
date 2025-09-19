package org.example;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        // Registration
        System.out.println("\n--- Registration ---");
        System.out.print("Enter UserName: ");
        String userName = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter phone number (+27): ");
        String phone = scanner.nextLine();

        String regMessage = login.registerUser(userName, password, phone);
        System.out.println(regMessage);

        // Login
        if (regMessage.contains("User registered successfully")) {
            System.out.println("\n--- Login ----");
            System.out.print("Enter username to login: ");
            String loginUser = scanner.nextLine();

            System.out.print("Enter password to login: ");
            String loginPass = scanner.nextLine();

            String loginMessage = login.returnLoginStatus(loginUser, loginPass, firstName, lastName);
            System.out.println(loginMessage);
        } else {
            System.out.println("\nRegistration failed. Cannot continue to login.");
        }
        scanner.close();
    }
}