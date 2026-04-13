package com.mycompany.mychatapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            Register reg = new Register();
            Login login = null;

            boolean isRegistered = false;
            boolean running = true;

            while (running) {

                System.out.println("\n=== MENU ===");

                if (!isRegistered) {
                    System.out.println("1. Register");
                    System.out.println("2. Exit");
                } else {
                    System.out.println("1. Login");
                    System.out.println("2. Exit");
                }

                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (!isRegistered) {

                    switch (choice) {
                        case 1 -> {
                            reg.registerUser(sc);
                            isRegistered = true;

                            // create Login object using registered details
                            login = new Login(reg.getUsername(), reg.getPassword());
                        }
                        case 2 -> {
                            System.out.println("Goodbye!");
                            running = false;
                        }
                        default -> System.out.println("Invalid choice.");
                    }

                } else {

                    switch (choice) {
                        case 1 -> {
                            if (login.loginUser(sc)) {
                                running = false;
                            }
                        }
                        case 2 -> {
                            System.out.println("Goodbye!");
                            running = false;
                        }
                        default -> System.out.println("Invalid choice.");
                    }
                }
            }
        }
    }
}
