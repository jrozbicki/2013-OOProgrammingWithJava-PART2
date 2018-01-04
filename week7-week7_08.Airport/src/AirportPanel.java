import java.util.ArrayList;
import java.util.Scanner;

public class AirportPanel {
    private Scanner reader;
    private Plane plane;
    private Flight flight;

    public AirportPanel(Scanner reader, Plane plane, Flight flight) {
        this.reader = reader;
        this.plane = plane;
        this.flight = flight;
    }

    /*

            ///////////// AIRPORT PANEL /////////////

     */

    public void startAirportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");

        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.print(">");

            String userInput = this.reader.nextLine();

            if (userInput.equals("1")) {
                addAirPlane();
            } else if (userInput.equals("2")) {
                addFlight();
            } else if (userInput.equals("x")) {
                break;
            }
        }
    }

    public void addAirPlane(){
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();

        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());

        this.plane.addPlane(planeID, capacity);
    }

    public void addFlight(){
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();

        System.out.print("Give departure airport code: ");
        String departureCode = reader.nextLine();

        System.out.print("Give destination airport code: ");
        String destinationCode = reader.nextLine();

        int capacity = this.plane.getCapacity(planeID);

        this.flight.addFlight(planeID, capacity, departureCode, destinationCode);
    }

    /*

                ///////////// FLIGHT SERVICE /////////////

     */
    public void startFlightService(){
        System.out.println("");
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");

        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            System.out.print(">");

            String userInput = this.reader.nextLine();

            if (userInput.equals("1")) {
                printAllPlanes();
            } else if (userInput.equals("2")) {
                printAllFlights();
            } else if (userInput.equals("3")) {
                System.out.print("Give plane ID: ");
                String planeID = reader.nextLine();
                printPlaneInfo(planeID);
            } else if(userInput.equals("x")) {
                break;
            }
        }
    }

    public void printAllPlanes(){
        plane.printPlanes();
    }

    public void printAllFlights(){
        flight.printFlights();
    }

    public void printPlaneInfo(String planeID){
        plane.printOnePlane(planeID);
    }
}
