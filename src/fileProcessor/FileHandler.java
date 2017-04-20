package fileProcessor;

import travel.City;
import travel.Flight;
import user.Login;
import user.Ticket;
import java.io.*;
import java.util.ArrayList;

/**
 * @author andro
 */
public class FileHandler {

    public void signUp(int index, String title, String firstName, String lastName,
                       String emailId, String address, String password, long mobileNumber)
            throws IOException {

        try (FileWriter fw = new FileWriter("UserList.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(Integer.toString(index) + ".");
            out.println("Title : " + title);
            out.println("First Name : " + firstName);
            out.println("Last Name : " + lastName);
            out.println("Email Id : " + emailId);
            out.println("Address : " + address);
            out.println("Password : " + password);
            out.println("Mobile Number : " + Long.toString(mobileNumber));
        } finally {
            System.out.println("User creation Successful, now you can login "
                    + "using your Email Id and Password");
        }
    }

    public void confirmTicket(Flight flight, ArrayList<Ticket> ticketList, Login login) throws IOException {
        int counter = 1;
        for (Ticket t : ticketList) {
            counter++;
        }
        try (FileWriter fw = new FileWriter("TicketList.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println();
            out.println("Title : " + login.getTitle());
            out.println("First Name : " + login.getFirstName());
            out.println("Last Name : " + login.getLastName());
            out.println("Email Id : " + login.getEmailId());
            out.println("Source : " + flight.getSource());
            out.println("Destination : " + flight.getDestination());
            out.println("Airline : " + flight.getAirline());
            out.println("Flight Code : " + flight.getFlightCode());
            out.println("Flight Time : " + flight.getFlightTime());
            out.println("Departure Time : " + flight.getDepartureTime());
            out.println("Arrival Time : " + flight.getArrivalTime());
            out.println("Cancelled : No");
            out.println("Index : " + counter);
        } finally {
            System.out.println("Congratulations, Flight Booked Successfully!");
        }
    }

    public ArrayList<Login> readUser() throws IOException {
        ArrayList<Login> userList;
        try {
            BufferedReader br = new BufferedReader(new FileReader("UserList.txt"));
            Login login = new Login();
            String line;
            int counter = 2;
            StringBuilder builder = new StringBuilder(Integer.toString(counter));
            builder.append(".");
            login.setIndex(1);
            userList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Title : ")) {
                    login.setTitle(line.substring(8));
                } else if (line.startsWith("First Name : ")) {
                    login.setFirstName(line.substring(13));
                } else if (line.startsWith("Last Name : ")) {
                    login.setLastName(line.substring(12));
                } else if (line.startsWith("Email Id : ")) {
                    login.setEmailId(line.substring(11));
                } else if (line.startsWith("Address : ")) {
                    login.setAddress(line.substring(10));
                } else if (line.startsWith("Password : ")) {
                    login.setPassword(line.substring(11));
                } else if (line.startsWith("Mobile Number : ")) {
                    login.setMobileNumber(Long.parseLong(line.substring(16)));
                } else if (line.startsWith(builder.toString())) {
                    userList.add(login);
                    login.setIndex(counter++);
                    login = new Login();
                    builder = new StringBuilder(Integer.toString(counter));
                    builder.append(".");
                }
            }
            login.setIndex(counter++);
            userList.add(login);
            login = new Login();
        } finally {
            System.out.println("Reading users done...");
        }
        return userList;
    }

    public ArrayList<City> readCities() throws IOException {
        ArrayList<City> cityList;
        try {
            BufferedReader br = new BufferedReader(new FileReader("CityList.txt"));
            cityList = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                City city = new City();
                String[] data = new String[2];
                data = line.split(" ");
                city.setName(data[0]);
                city.setCode(data[1]);
                cityList.add(city);
            }
        } finally {
            System.out.println("Reading cities done...");
        }
        return cityList;
    }

    public ArrayList<Flight> readFlights() throws IOException {
        ArrayList<Flight> flightList;

        try {
            BufferedReader br = new BufferedReader(new FileReader("FlightList.txt"));
            String line;
            flightList = new ArrayList<>();
            Flight flight = new Flight();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Source : ")) {
                    flight.setSource(line.substring(9));
                } else if (line.startsWith("Destination : ")) {
                    flight.setDestination(line.substring(14));
                } else if (line.startsWith("Airline : ")) {
                    flight.setAirline(line.substring(10));
                } else if (line.startsWith("Flight Code : ")) {
                    flight.setFlightCode(line.substring(14));
                } else if (line.startsWith("Flight Time : ")) {
                    flight.setFlightTime(line.substring(14));
                } else if (line.startsWith("Departure Time : ")) {
                    flight.setDepartureTime(line.substring(17));
                } else if (line.startsWith("Arrival Time : ")) {
                    flight.setArrivalTime(line.substring(15));
                } else if (line.startsWith("Index : ")) {
                    flight.setIndex(Integer.parseInt(line.substring(8)));
                    flightList.add(flight);
                    flight = new Flight();
                }
            }
        } finally {
            System.out.println("Reading flights done...");
        }
        return flightList;
    }

    public ArrayList<Ticket> readTickets() throws IOException {
        ArrayList<Ticket> ticketList;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("TicketList.txt"));
            String line;
            ticketList = new ArrayList<>();
            Ticket ticket = new Ticket();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Title : ")) {
                    ticket.setTitle(line.substring(8));
                } else if (line.startsWith("First Name : ")) {
                    ticket.setFirstName(line.substring(13));
                } else if (line.startsWith("Last Name : ")) {
                    ticket.setLastName(line.substring(12));
                } else if (line.startsWith("Email Id : ")) {
                    ticket.setEmailId(line.substring(11));
                } else if (line.startsWith("Source : ")) {
                    ticket.setSource(line.substring(9));
                } else if (line.startsWith("Destination : ")) {
                    ticket.setDestination(line.substring(14));
                } else if (line.startsWith("Airline : ")) {
                    ticket.setAirline(line.substring(10));
                } else if (line.startsWith("Flight Code : ")) {
                    ticket.setFlightCode(line.substring(14));
                } else if (line.startsWith("Flight Time : ")) {
                    ticket.setFlightTime(line.substring(14));
                } else if (line.startsWith("Departure Time : ")) {
                    ticket.setDepartureTime(line.substring(17));
                } else if (line.startsWith("Arrival Time : ")) {
                    ticket.setArrivalTime(line.substring(15));
                } else if (line.startsWith("Cancelled : ")) {
                    if (line.substring(12).equals("Yes")) {
                        ticket.setIsCancelled(true);
                    } else if (line.substring(12).equals("No")) {
                        ticket.setIsCancelled(false);
                    }
                } else if (line.startsWith("Index : ")) {
                    ticket.setIndex(Integer.parseInt(line.substring(8)));
                    ticketList.add(ticket);
                    ticket = new Ticket();
                }
            }
        } finally {
            System.out.println("Reading tickets done...");
        }
        return ticketList;
    }
}