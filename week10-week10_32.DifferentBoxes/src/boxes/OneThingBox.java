package boxes;

import java.util.ArrayList;
import java.util.List;

public class OneThingBox extends Box {
    private List<Thing> listOfThingsInTheBox;

    public OneThingBox(){
        this.listOfThingsInTheBox = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if(listOfThingsInTheBox.size()<1){
            listOfThingsInTheBox.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if(listOfThingsInTheBox.contains(thing)){
            return true;
        } else{
            return false;
        }
    }
}
