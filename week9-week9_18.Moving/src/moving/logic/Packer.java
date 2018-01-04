package moving.logic;

import moving.domain.Box;
import moving.domain.Thing;

import java.util.ArrayList;
import java.util.List;

public class Packer {
    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> listOfBoxes = new ArrayList<Box>();
        Box box = new Box(this.boxesVolume);
        for (Thing each : things) {
            if(box.addThing(each)) {

            } else {
                listOfBoxes.add(box);
                box = new Box(this.boxesVolume);
                box.addThing(each);
            }
        }
        listOfBoxes.add(box);
        return listOfBoxes;
    }

}


