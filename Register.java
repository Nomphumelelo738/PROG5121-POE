package com.mycompany.login;

import java.util.Scanner;

public class Register {

    private String storedFirstName;
    private String storedLastName;
    private String storedUsername;
    private String storedPassword;
    private String storedPhone;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPassword(String password) {

        if (password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return hasUpper && hasNumber && hasSpecial;
    }

    public boolean checkPhone(String phone) {

        if (!phone.startsWith("+27")) {
            return false;
        }

        if (phone.length() != 12) {
            return false;
        }

        for (int i = 3; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public void registerUser(Scanner sc) {

        System.out.println("=== REGISTER ===");

        System.out.print("Enter first name: ");
        storedFirstName = sc.nextLine();

        System.out.print("Enter last name: ");
        storedLastName = sc.nextLine();

        while (true) {

            System.out.print("Enter username: ");
            String username = sc.nextLine();

            if (checkUserName(username)) {
                storedUsername = username;
                break;
            } else {
                System.out.println("Username must contain _ and be <= 5 characters.");
            }
        }

        while (true) {

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (checkPassword(password)) {
                storedPassword = password;
                break;
            } else {
                System.out.println("Password invalid.");
            }
        }

        while (true) {

            System.out.print("Enter phone (+27...): ");
            String phone = sc.nextLine();

            if (checkPhone(phone)) {
                storedPhone = phone;
                break;
            } else {
                System.out.println("Invalid phone number.");
            }
        }

        System.out.println("Registration successful!\n");
    }

    public String getFirstName() {
        return storedFirstName;
    }

    public String getLastName() {
        return storedLastName;
    }

    public String getUsername() {
        return storedUsername;
    }

    public String getPassword() {
        return storedPassword;
    }

    public String getPhone() {
        return storedPhone;
    }
}
