import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Locale;


public class Passenger {

    //Properties
    private String name;
    private String contact;
    private String passengerId;
    private static List<Passenger> passengers;
    public Flight flight;

    //Constructor
    public Passenger(String name, String contact){
        this.name = name;
        this.contact = contact;
        createPassengerId();
    }
    //Method to create passengerId
    public void createPassengerId(){

        int length = 7;
        boolean useLetters = true;
        boolean useNumbers = true;
        this.passengerId = RandomStringUtils.random(length, useLetters, useNumbers).toUpperCase();

    }
    //Method to book a flight
    public void bookFlight(Flight flight){
        this.flight = flight;
        System.out.println(this.name + " your flight " + flight.getFlightId()
                            + " has been booked.");
        System.out.println("Enjoy your holiday in " + flight.getDestination());
    }


    //Method to cancel a flight
    public void cancelFlight(Flight flight){

        flight.getPassengers().remove(this);
        System.out.println(this.name + ", your flight " + flight.getFlightId()
                           + " has been cancelled.");

        // do you want to book another flight? boolean
    }




}

