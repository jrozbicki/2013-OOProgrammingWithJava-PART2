package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing{
    private int maximumCapacity;
    private List<Thing> listOfThingsInThisBox = new ArrayList<Thing>();

    public Box(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
    }

    public boolean addThing(Thing thing){
        if(thing.getVolume()+this.getVolume()<=this.maximumCapacity){
            this.listOfThingsInThisBox.add(thing);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getVolume(){
        int volume = 0;
        for (Thing each : listOfThingsInThisBox){
            volume+=each.getVolume();
        }
        return volume;
    }


    public List<Thing> print(){
        return listOfThingsInThisBox;
    }

}
