/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import fileProcessor.FileHandler;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author andro
 */
public class SignUp {

    public void prepSignUp(int index) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello New User!");
        System.out.println("Please provide in with your details so that can we "
                + "can create your account");
        System.out.print("Enter your Name Title - ");
        String title = scanner.nextLine();
        System.out.print("Enter your First Name - ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your Last Name - ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your Email ID - ");
        String emailId = scanner.nextLine();
        System.out.print("Enter your Address - ");
        String address = scanner.nextLine();
        System.out.print("Enter your Password - ");
        String password = scanner.nextLine();
        System.out.print("Enter your Mobile Number - ");
        long mobileNumber = scanner.nextLong();

        FileHandler handler = new FileHandler();
        try {
            handler.signUp(index, title, firstName, lastName, emailId, address, password, mobileNumber);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}