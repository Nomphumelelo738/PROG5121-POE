package com.mycompany.login;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ================= REGISTER =================

        Register register = new Register();

        register.registerUser(scanner);

        // ================= LOGIN =================

        Login login = new Login(
                register.getFirstName(),
                register.getLastName(),
                register.getUsername(),
                register.getPassword(),
                register.getPhone()
        );

        System.out.println("=== LOGIN ===");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (!login.loginUser(username, password)) {

            System.out.println(
                    login.returnLoginStatus(username, password));

            return;
        }

        System.out.println(
                login.returnLoginStatus(username, password));

        System.out.println("Welcome to QuickChat!");

        // ================= MESSAGES =================

        System.out.print("How many messages do you want to send? ");

        int maxMessages =
                Integer.parseInt(scanner.nextLine());

        int count = 0;

        while (count < maxMessages) {

            System.out.println("\n1. Send Message");
            System.out.println("2. View Sent Messages");
            System.out.println("3. Quit");

            System.out.print("Choose option: ");

            int choice =
                    Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1 -> {

                    System.out.print("Recipient: ");
                    String recipient =
                            scanner.nextLine();

                    System.out.print("Message: ");
                    String text =
                            scanner.nextLine();

                    System.out.println(
                            Message.checkMessageLength(text));

                    if (text.length() <= 250) {

                        count++;

                        Message msg =
                                new Message(
                                        count,
                                        recipient,
                                        text);

                        System.out.println(
                                msg.sendMessage());
                    }
                }

                case 2 -> {

                    System.out.println(
                            Message.printMessages());
                }

                case 3 -> {

                    System.out.println(
                            "Total messages sent: "
                            + Message.returnTotalMessages());

                    System.out.println("Goodbye!");

                    scanner.close();

                    return;
                }

                default -> {
                    System.out.println("Invalid option.");
                }
            }
        }

        scanner.close();
    }
}