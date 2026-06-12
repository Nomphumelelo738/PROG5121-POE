package com.mycompany.login;

public class Login {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phone;

    public Login(String firstName,
                 String lastName,
                 String username,
                 String password,
                 String phone) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public boolean loginUser(String inputUsername,
                             String inputPassword) {

        return inputUsername.equals(username)
                && inputPassword.equals(password);
    }

    public String returnLoginStatus(String inputUsername,
                                    String inputPassword) {

        if (loginUser(inputUsername, inputPassword)) {

            return "Welcome "
                    + firstName + " "
                    + lastName
                    + ", it is great to see you again.";

        } else {

            return "Username or password incorrect.";
        }
    }
}

