/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel;

/**
 * @author andro
 */
public class Flight {

    private String source;
    private String destination;
    private String airline;
    private String flightCode;
    private String flightTime;
    private String departureTime;
    private String arrivalTime;
    private int index;

    public void printDetails() {
        System.out.println(String.format("Flight %s %s from %s to %s",
                this.getAirline(), this.getFlightCode(), this.getSource(), this.getDestination()));
        System.out.println("Departure  Time : " + this.getDepartureTime());
        System.out.println("Arrival  Time : " + this.getArrivalTime());
        System.out.println("Flight Duration : " + this.getFlightTime());
    }

    public boolean searchFlight(String source, String destination) {
        return this.getSource().equalsIgnoreCase(source) && this.getDestination().equalsIgnoreCase(destination);
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
