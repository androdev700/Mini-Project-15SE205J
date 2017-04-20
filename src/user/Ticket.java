/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public void printDetails() {
        System.out.println("We found the following bookings made by you..");
        System.out.println(String.format("Flight %s %s from %s to %s",
                this.airline, this.flightCode, this.source, this.destination));
        System.out.println(String.format("%s %s %s", this.title, this.firstName, this.lastName));
        System.out.println("Departure Time : " + this.departureTime);
        System.out.println("Arrival Time : " + this.arrivalTime);
        System.out.println("Flight Duration : " + this.flightTime);
        System.out.println(isCancelled ? "This flight is cancelled" : "This flight is scheduled");
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return this.emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return this.source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return this.destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the airline
     */
    public String getAirline() {
        return this.airline;
    }

    /**
     * @param airline the airline to set
     */
    public void setAirline(String airline) {
        this.airline = airline;
    }

    /**
     * @return the flightCode
     */
    public String getFlightCode() {
        return this.flightCode;
    }

    /**
     * @param flightCode the flightCode to set
     */
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    /**
     * @return the flightTime
     */
    public String getFlightTime() {
        return this.flightTime;
    }

    /**
     * @param flightTime the flightTime to set
     */
    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    /**
     * @return the departureTime
     */
    public String getDepartureTime() {
        return this.departureTime;
    }

    /**
     * @param departureTime the departureTime to set
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * @return the arrivalTime
     */
    public String getArrivalTime() {
        return this.arrivalTime;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the isCancelled
     */
    public boolean isCancelled() {
        return this.isCancelled;
    }

    /**
     * @param isCancelled the isCancelled to set
     */
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
