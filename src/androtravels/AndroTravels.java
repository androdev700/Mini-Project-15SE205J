package androtravels;

import fileProcessor.FileHandler;
import travel.City;
import travel.Flight;
import user.Login;
import user.SignUp;
import user.Ticket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TITLE -> FLIGHT BOOKING SYSTEM
 *
 * @author AYUSH SINGH [RA1511008010221] B.Tech IT
 * @author NIKHIL SHAW [RA1511008010233] B.Tech IT
 * @version 1.0
 */
public class AndroTravels {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InputMismatchException {

        try {
            for (int i = 0; i < 1; ++i) {
                System.out.print("Reading files");
                for (int j = 0; j < 3; j++) {
                    System.out.print(".");
                    Thread.sleep(400);
                }
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println(e.getCause());
        }

        Scanner scanner = new Scanner(System.in);
        FileHandler handler = new FileHandler();
        ArrayList<Login> userList = handler.readUser();
        ArrayList<City> cityList = handler.readCities();
        ArrayList<Flight> flightList = handler.readFlights();
        ArrayList<Ticket> ticketList = handler.readTickets();

        System.out.println("Welcome to andro Flight booking system");
        System.out.println("Are you an existing customer ?");

        while (true) {
            String choice = scanner.nextLine();
            choice = choice.toLowerCase();
            switch (choice) {
                case "yes":
                case "y":
                    Login l = new Login();
                    l.performLogin(userList, cityList, flightList, ticketList, handler);
                    break;
                case "no":
                case "n":
                    SignUp signUp = new SignUp();
                    signUp.prepSignUp(userList.size() + 1);
                    userList = handler.readUser();
                    choice = "yes";
                    break;
                default:
                    //UI FEEDBACK
                    System.out.println("Try again, enter a valid choice");
                    break;
            }
        }
    }
}
