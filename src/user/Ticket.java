/*
Ticket.java
(Use to print ticket details)
FUNCTIONS:
* public void printDetails()
*/

package user;

/**
 * @author andro
 */
public class Ticket {

    private String title;
    private String firstName;
    private String lastName;
    private String emailId;
    private String source;
    private String destination;
    private String airline;
    private String flightCode;
    private String flightTime;
    private String departureTime;
    private String arrivalTime;
    private int index;
    private boolean isCancelled;

    public void printDetails() { // Print details of the booked flights if any
        System.out.println("We found the following bookings made by you..");
        System.out.println(String.format("Flight %s %s from %s to %s",
                this.airline, this.flightCode, this.source, this.destination));
        System.out.println(String.format("%s %s %s", this.title, this.firstName, this.lastName));
        System.out.println("Departure Time : " + this.departureTime);
        System.out.println("Arrival Time : " + this.arrivalTime);
        System.out.println("Flight Duration : " + this.flightTime);
        System.out.println(isCancelled ? "This flight is cancelled" : "This flight is scheduled");
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return this.airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightCode() {
        return this.flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getFlightTime() {
        return this.flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
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
}