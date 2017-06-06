/*
SignUp.java
(Menu to create a new account)
FUNCTIONS:
* public void prepSignUp(int index)
*/

package user;

import fileProcessor.FileHandler;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author andro
 */
public class SignUp {

    public void prepSignUp(int index) throws IOException, InputMismatchException {
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
        // call handler.signUp to wriet ti UserList.txt
        handler.signUp(index, title, firstName, lastName, emailId, address, password, mobileNumber);
    }
}