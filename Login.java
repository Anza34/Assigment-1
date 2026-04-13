/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author Student
 */
import java.util.Scanner;

class Signup {

    String savedUsername;
    String savedPassword;

    // Check Username
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check Password Complexity
    public boolean checkPasswordComplexity(String password) {
        String capital = ".*[A-Z].*";
        String digit = ".*[0-9].*";
        String special = ".*[!@#$%^&*].*";

        return( password.length() >=8 &&password.matches(capital) &&password.matches(digit) &&password.matches(special));
    }

    // Check Cell Phone Number
    public boolean checkCellPhoneNumber(String phone) {
        if (phone.startsWith("+27") && phone.length() == 12) {
            for (int i = 3; i < phone.length(); i++) {
                if (!Character.isDigit(phone.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // Register User
    public String registerUser(String username, String password, String phone) {

        if (!checkUserName(username)) {
            return "Username must contain an underscore and be no more than 5 characters.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password must be at least 8 characters, include a capital letter, number, and special character.";
        }

        if (!checkCellPhoneNumber(phone)) {
            return "Cell number must start with +27 and be 12 digits long.";
        }

        // SAVE USER DETAILS
        savedUsername = username;
        savedPassword = password;

        return "Registration successful!";
    }

    // Login User
    public boolean loginUser(String username, String password) {
        return username.equals(savedUsername) && password.equals(savedPassword);
    }

    // Login Status Message
    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Successfuly login";
        } else {
            return "Username or password incorrect.";
        }
    }
}

public class Login {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Signup signup = new Signup();

        System.out.println("=== REGISTER ===");

        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = input.nextLine();

        String result = signup.registerUser(username, password, phone);
        System.out.println(result);

        // Only continue if registration worked
        if (result.equals("Registration successful!")) {

            System.out.println("\n=== LOGIN ===");

            System.out.print("Enter Username: ");
            String loginUser = input.nextLine();

            System.out.print("Enter Password: ");
            String loginPass = input.nextLine();

            boolean status = signup.loginUser(loginUser, loginPass);
            System.out.println(signup.returnLoginStatus(status));
        }

        input.close();
    }
}

