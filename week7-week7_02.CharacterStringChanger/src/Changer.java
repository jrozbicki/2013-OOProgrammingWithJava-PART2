import java.util.ArrayList;
import java.util.Arrays;

public class Changer {
    private ArrayList<Change> listOfChangesDone = new ArrayList<Change>();
    public Changer(){}

    public void addChange(Change change) {
        listOfChangesDone.add(change);
    }

    public String change(String characterString) {
        for(Change each : listOfChangesDone){
            characterString = each.change(characterString);
        }
        return characterString;
    }
}
