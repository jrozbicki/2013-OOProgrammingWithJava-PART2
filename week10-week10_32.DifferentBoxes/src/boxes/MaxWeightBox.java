package boxes;

import java.util.ArrayList;

import java.util.List;

public class MaxWeightBox extends Box{
    private int maxWeight;
    private List<Thing> listOfThingsInTheBox;

    public MaxWeightBox(int maxWeight){
        this.maxWeight = maxWeight;
        this.listOfThingsInTheBox = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        int volume = 0;
        for(Thing each : listOfThingsInTheBox){
            volume += each.getWeight();
        }
        if(volume+thing.getWeight()<=this.maxWeight){
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
