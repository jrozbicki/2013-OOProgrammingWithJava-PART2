import java.util.ArrayList;

public class Suitcase {
    private int weightLimit;
    private ArrayList<Thing> things = new ArrayList<Thing>();
    private int currentWeight;


    public Suitcase(int weightLimitC) {
        this.weightLimit = weightLimitC;
    }

    public void addThing(Thing thingM) {
        this.currentWeight += thingM.getWeight();
        if (this.currentWeight <= this.weightLimit) {
            this.things.add(thingM);
        } else {
            this.currentWeight -= thingM.getWeight();
        }
    }

    public void printThings(){
        for (Thing each : things){
            System.out.println(each.toString());
        }
    }

    public int totalWeight(){
        return this.currentWeight;

    }

    public Thing heaviestThing() {
        Thing heaviestThing = new Thing("heaviest", 0);
        for(Thing each : this.things){
            if (each.getWeight()>=heaviestThing.getWeight()){
                heaviestThing=each;
            }
        }
        if (this.things.size()==0){
            return null;
        } else {
            return heaviestThing;
        }
    }

    public String toString() {
        String properString;
        if (this.things.size() == 0) {
            properString = "empty (" + this.currentWeight + " kg)";
        } else if (this.things.size() == 1) {
            properString = this.things.size() + " thing (" + this.currentWeight + " kg)";
        } else {
            properString = this.things.size() + " things (" + this.currentWeight + " kg)";
        }
        return properString;
    }
}
