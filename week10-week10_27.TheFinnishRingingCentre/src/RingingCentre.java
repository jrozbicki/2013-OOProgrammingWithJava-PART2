import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {

    private Map<Bird, List<String>> listOfBirds;

    public RingingCentre(){
        this.listOfBirds = new HashMap<Bird, List<String>>();

    }

    public void observe(Bird bird, String place){
        if(!listOfBirds.keySet().contains(bird)){
            List<String> listOfPlaces = new ArrayList<String>();
            listOfPlaces.add(place);
            listOfBirds.put(bird, listOfPlaces);
        } else {
            for (Bird each : listOfBirds.keySet()){
                if(each.equals(bird)){
                    listOfBirds.get(each).add(place);
                }
            }
        }
    }

    public void observations(Bird bird){
        if(listOfBirds.keySet().contains(bird)) {
            int counter = listOfBirds.get(bird).size();
            System.out.println(bird.toString() + " observations: " + counter);
            for (String each : listOfBirds.get(bird)) {
                System.out.println(each);
            }
        } else {
            System.out.println(bird.toString() + " observations: 0");
        }
    }
}
