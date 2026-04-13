package com.mycompany.mychatapp;

import java.util.Scanner;

class Login {

    private String username;
    private String password;

    // constructor to receive registered data
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean loginUser(Scanner sc) {

        int attempts = 0;

        while (attempts < 3) {

            System.out.print("Enter username: ");
            String inputUser = sc.nextLine();

            System.out.print("Enter password: ");
            String inputPass = sc.nextLine();

            if (inputUser.equals(username) && inputPass.equals(password)) {
                System.out.println("Login successful!");
                return true;
            } else {
                attempts++;
                System.out.println("Incorrect. Attempts left: " + (3 - attempts));
            }
        }

        System.out.println("Too many attempts.");
        return false;
    }
}