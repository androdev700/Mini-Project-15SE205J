/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import androtravels.AndroTravels;
import fileProcessor.FileHandler;
import travel.City;
import travel.Flight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author andro
 */
public class Login {

    private String title;
    private String firstName;
    private String lastName;
    private String emailId;
    private String address;
    private String password;
    private long mobileNumber;
    private int index;

    public void accountDetails(Login user) {
        System.out.println(String.format("%s %s %s", user.getTitle(), user.getFirstName(), user.getLastName()));
        System.out.println(String.format("Email Id : %s", user.getEmailId()));
        System.out.println(String.format("Address : %s", user.getAddress()));
        System.out.println(String.format("Mobile Number : %s", user.getMobileNumber()));
    }

    public boolean verifyUser(String emailId, String password) {
        return (this.getEmailId().equalsIgnoreCase(emailId) && this.getPassword().equals(password));
    }

    public void userPortal(int index, ArrayList<Login> userList,
                           ArrayList<City> cityList,
                           ArrayList<Flight> flightList, ArrayList<Ticket> ticketList,
                           FileHandler handler) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Welcome %s %s",
                userList.get(index).getTitle(),
                userList.get(index).getLastName()));

        System.out.println("1. View/Edit your account details");
        System.out.println("2. Book a flight");
        System.out.println("3. View booked flights");
        System.out.println("4. Check flight status");
        System.out.println("5. Logout");

        while (true) {
            System.out.print("Enter Your Choice : ");
            int menuChoice = scanner.nextInt();
            switch (menuChoice) {
                case 1:
                    accountDetails(userList.get(index));
                    System.out.println("\nPress 1 to edit details");
                    break;
                case 2:
                    String source;
                    String destination;
                    boolean flightFound = false;
                    boolean inputValidSource = false;
                    boolean inputValidDestination = false;
                    while (!inputValidSource && !inputValidDestination) {
                        System.out.println("Enter source or it's location "
                                + "code -->");
                        source = scanner.next();
                        for (City city : cityList) {
                            if (city.getName().equalsIgnoreCase(source)
                                    || city.getCode().equalsIgnoreCase(source)) {
                                inputValidSource = true;
                            }
                        }
                        System.out.println("Entet destination or it's location "
                                + "code -->");
                        destination = scanner.next();
                        for (City city : cityList) {
                            if (city.getName().equalsIgnoreCase(destination)
                                    || city.getCode().equalsIgnoreCase(destination)) {
                                inputValidDestination = true;
                            }
                        }
                        //UI FEEDBACK
                        if (!inputValidSource) {
                            System.out.println("Enter a valid source or it's "
                                    + "location code.");
                            continue;
                        } else if (!inputValidDestination) {
                            System.out.println("Enter a valid destination or "
                                    + "it's location code.");
                            continue;
                        }
                        ArrayList<Integer> nFlights = new ArrayList<>();
                        for (Flight f : flightList) {
                            if (f.searchFlight(source, destination)) {
                                flightFound = true;
                                nFlights.add(f.getIndex());
                            }
                        }
                        if (!flightFound) {
                            System.out.println("Sorry couldn't find any flight "
                                    + "in this route.");
                            System.out.println("");
                        } else {
                            System.out.println("We found the following flights "
                                    + "in this route");
                            System.out.println("");
                            for (int n : nFlights) {
                                System.out.println(n + 1 + ".");
                                flightList.get(n).printDetails();
                            }
                            System.out.println("Choose your flight");
                            System.out.println("");
                            int selection = scanner.nextInt();
                            selection -= 1;
                            System.out.println("You have selected ..");
                            flightList.get(selection).printDetails();
                            System.out.println("");
                            System.out.println("Do you wanna confirm this "
                                    + "flight?");
                            String choice = scanner.nextLine();
                            choice = choice.toLowerCase();
                            if (choice.equals("yes") || choice.equals("y")) {

                            }
                        }
                    }
                    break;
                case 3:
                    ArrayList<Integer> nTickets = new ArrayList<>();
                    String localEmailId = userList.get(index).getEmailId();
                    for (Ticket t : ticketList) {
                        if (t.getEmailId().equals(localEmailId)) {
                            nTickets.add(t.getIndex());
                        }
                    }
                    for (Integer i : nTickets) {
                        ticketList.get(i - 1).printDetails();
                    }
                    break;
                case 4:
                    String choice = "yes";
                    while (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                        System.out.print("Enter flight code : ");
                        String code = scanner.next();
                        flightFound = false;
                        for (Flight f : flightList) {
                            if (f.getFlightCode().equals(code)) {
                                f.printDetails();
                                flightFound = true;
                            }
                        }
                        System.out.println(flightFound ? "" : "Flight not found");
                        System.out.println("Search again? Yes/No");
                        choice = scanner.next();
                    }
                    break;
                case 5:
                    System.out.println("Logged out!, Do you want to login again?");
                    AndroTravels travels = new AndroTravels();
                    String[] args = new String[2];
                    travels.main(args);
                    break;
                default:
                    break;
            }
        }
    }

    public void performLogin(ArrayList<Login> userList, ArrayList<City> cityList,
                             ArrayList<Flight> flightList, ArrayList<Ticket> ticketList,
                             FileHandler handler) throws IOException {

        boolean validUser = false;
        Scanner scanner = new Scanner(System.in);

        String localEmailId, localPassword;
        int localIndex = 0;

        while (!validUser) {
            System.out.println("Enter Your email id : ");
            localEmailId = scanner.nextLine();
            System.out.println("Enter your password : ");
            localPassword = scanner.nextLine();
            for (Login l : userList) {
                validUser = l.verifyUser(localEmailId, localPassword);
                localIndex = l.getIndex();
                if (validUser) {
                    break;
                }
            }
            if (!validUser) {
                //UI FEEDBACK
                System.out.println("Enter valid login");
            } else {
                localIndex -= 2;
                userPortal(localIndex, userList, cityList, flightList, ticketList, handler);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
