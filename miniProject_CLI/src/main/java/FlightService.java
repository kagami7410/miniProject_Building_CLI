import java.util.ArrayList;
import java.util.List;

public class FlightService {

    //Properties

    private List<Flight> flights;

    //Constructor
    public FlightService(){
        this.flights = new ArrayList<>();
    }



    //Method to add flight
    public void addFlight(Flight flight){
        this.flights.add(flight);
    }


    //Method to remove flight
    public void removeFlight(Flight flight){
        this.flights.remove(flight);
    }


    //Method to search for destination
    public List<Flight> searchDestination(String destination){
        List<Flight> searchingResult = flights.stream()
                .filter(des -> des.getDestination().equals(destination))
                .toList();
        return searchingResult;

    }

    //Getters
    public List<Flight> getFlights(){
        return this.flights;
    }




}
