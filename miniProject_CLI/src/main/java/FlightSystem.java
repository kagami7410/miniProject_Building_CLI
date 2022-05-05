import java.util.Scanner;

public class FlightSystem {
    private Scanner scanner;
    private PassengerService passengerService;
    private FlightService flightService;




    public FlightSystem(){
        this.flightService = new FlightService();
        flightService.addFlight(new Flight("London"));
        flightService.addFlight(new Flight("Manchester"));
        this.passengerService = new PassengerService();
        this.scanner = new Scanner(System.in);
    }

    public void intro(){
        System.out.println("Welcome to British Airways");
        System.out.println("Would you like a Passenger Service or a Flight Service");
        start();
    }

    public void start(){
        System.out.println("Type '1' if you are a customer and '2' if admin");
        System.out.println("1.Customer      2.Admin");
        int firstOption = scanner.nextInt();
        customerOrAdmin(firstOption);

    }


    //Exception
    public void customerOrAdmin(int option) {
        if (option == 1) {
            System.out.println("Are you an existing customer?");
            System.out.println("Enter \'Yes\' or \'No\'");
            String existingCustomerResponse = scanner.next().toLowerCase();
            customerAction(existingCustomerResponse);

        }else if (option == 2){
            adminAddFlight();

        }else{
            System.out.println("Wrong number!!!!!");
            this.start();
        }

    }


    private void customerAction(String response) {

        if(response.equals("yes")) {
            System.out.println("What is your passenger id?");
            String passengerId = scanner.next().toUpperCase();
            System.out.println("What action would you like to take?");

            System.out.println("Enter 1 for Cancel flight or       Enter 2 to book another flight");
        }
        else if(response.equals("no")) {
            System.out.println("Do you want to book with us?");
            String answer = scanner.next().toLowerCase();
            bookingFlight(answer);
        }
        else {
            this.start();
//            customerOrAdmin(option);
        }
    }

    public void bookingFlight(String answer){

        if(answer.equals("yes")){
            System.out.println("Do you have a preferred destination? ");
            String preferredAnswer = scanner.next().toLowerCase();
            if (preferredAnswer.equals("yes")) {
                System.out.println("Enter your destination");
                String destination = scanner.next().toUpperCase();
            // comeback later 

            }else {
                displayAllAvailbleFlights();
                System.out.println("Enter the flight id to book a flight");
                String userPreferredFlightId = scanner.next().toUpperCase();
                Flight userFlight = flightService.getFlightById(userPreferredFlightId);
                System.out.println("Enter your name");
                String passengerName = scanner.next();
                System.out.println("Enter your email address");
                String passengerContact = scanner.next();

                PassengerService passengerService1 = new PassengerService();
                passengerService1.addPassenger(new Passenger(passengerName, passengerContact));



            }

        } else takeAnymoreActionsOrEnd();

    }





    public void displayAllAvailbleFlights(){
        System.out.println("---Flight ID---|---Destination---");
        flightService.getFlights()
                .stream().forEach(f -> System.out.println("      " + f.getFlightId() + "           " + f.getDestination()));



//        String customerPreferredFlightId = scanner.next().toUpperCase();
    }


    public void adminAddFlight(){


        System.out.println("Do you want to add a flight?");
        String adminAnswer = scanner.next().toLowerCase();
        if(adminAnswer.equals("yes")){
            System.out.println("Please enter the destination of the flight.");
            String destination = scanner.next();
            flightService.addFlight(new Flight(destination));
            takeAnymoreActionsOrEnd();

        }else{
            takeAnymoreActionsOrEnd();
        }
    }

    public void takeAnymoreActionsOrEnd(){
        System.out.println("We would love to hear from you in the future!");
        System.out.println("Would you like to take anymore actions?");
        String answer = scanner.next().toLowerCase();
        if(answer.equals("yes")) this.start();
        else System.out.println("See you next time");

    }


    public static void main(String[] args){
        FlightSystem fs = new FlightSystem();
        fs.intro();
    }











}
