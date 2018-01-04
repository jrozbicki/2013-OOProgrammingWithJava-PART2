import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.

        Scanner reader = new Scanner(System.in);
        Plane plane = new Plane();
        Flight flight = new Flight();
        AirportPanel panel1 = new AirportPanel(reader, plane, flight);

        panel1.startAirportPanel();
        panel1.startFlightService();
    }
}
