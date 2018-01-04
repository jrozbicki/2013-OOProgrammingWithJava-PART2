import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Plane {
    private HashMap<String, Integer> planesMap = new HashMap<String, Integer>();
    private ArrayList<String> listOfPlanes = new ArrayList<String>();

    public void addPlane(String planeID, int capacity) {
        planesMap.put(planeID, capacity);
    }

    public int getCapacity(String planeID) {
        return planesMap.get(planeID);
    }

    public void printPlanes() {
        for (String eachKey : planesMap.keySet()) {
            listOfPlanes.add(eachKey + " (" + planesMap.get(eachKey) + " ppl)");
        }

        for (String each : listOfPlanes) {
            System.out.println(each);
        }
    }

    public void printOnePlane(String planeID) {
        System.out.println(planeID + " (" + planesMap.get(planeID) + " ppl)");
    }


}

