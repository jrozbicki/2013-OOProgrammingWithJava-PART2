import java.util.ArrayList;

public class Flight {

    private ArrayList<String> flightList = new ArrayList<String>();

    public void addFlight(String planeID, int capacity, String departure, String destination){
        flightList.add(planeID+" ("+capacity+" ppl)"+" ("+departure+"-"+destination+")");
    }

    public void printFlights(){
        for(String eachFlight : flightList){
            System.out.println(eachFlight);
        }
    }
}
