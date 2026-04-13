package com.mycompany.mychatapp;


import java.util.Scanner;

class Register {

    private String storedUsername;
    private String storedPassword;
    private String storedPhone;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPassword(String password) {

        if (password.length() < 8) return false;

        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasNumber = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }

        return hasUpper && hasNumber && hasSpecial;
    }

    public boolean checkPhone(String phone) {
        if (!phone.startsWith("+27")) return false;
        if (phone.length() != 12) return false;

        for (int i = 3; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) return false;
        }
        return true;
    }

    public void registerUser(Scanner sc) {

        System.out.println("=== REGISTER ===");

        while (true) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            if (checkUserName(username)) {
                storedUsername = username;
                break;
            } else {
                System.out.println("Invalid Username, try again.");
            }
        }

        while (true) {
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (checkPassword(password)) {
                storedPassword = password;
                break;
            } else {
                System.out.println("Invalid Password, try again.");
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

    // getters (important for linking with Login)
    public String getUsername() {
        return storedUsername;
    }

    public String getPassword() {
        return storedPassword;
    }
}