import java.util.List;

public class Flight {

    //properties 
private String flightId;
private String destination;
private List<Passenger> passengers;
public static List<Flight> flights;

    //constructor
    public Flight(String flightId){
        this.flightId = flightId;
    }

    //Getters
    public String getFlightId() {
        return flightId;
    }

    public String getDestination() {
        return destination;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public static List<Flight> getFlights() {
        return flights;
    }


    //Method to add passengers
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    //Method to search destination
    public Flight searchDestination(String destination){
        return null;

    }


}
