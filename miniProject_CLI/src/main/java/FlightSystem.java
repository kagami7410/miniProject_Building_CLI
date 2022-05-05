import java.util.Scanner;

public class FlightSystem {
    private Scanner scanner;
    private PassengerService passengerService;
    private FlightService flightService;

    public FlightSystem(){
        this.flightService = new FlightService();
        this.passengerService = new PassengerService();
        this.scanner = new Scanner(System.in);
    }



    public void start(){
        // while()
        System.out.println("Welcome to British Airways");
        System.out.println("Would you like a Passenger Service or a Flight Service");
        System.out.println("Type '1' if you are a customer and '2' if admin");
        System.out.println("1.Customer      2.Admin");
        int firstOption = scanner.nextInt();
        customerOrAdmin(firstOption);



    }
    //Exception
    public void customerOrAdmin(int option) {
        try {
           int[] a = new int[]{1, 2, 3};
            System.out.println(a[3]);
        }catch(Exception exception){
            System.out.println("Wrong number!!!!!");
            this.start();
        }
    }


    public static void main(String[] args){
        FlightSystem fs = new FlightSystem();
        fs.start();
    }








}
