import java.util.ArrayList;

public class Container {
    private int maximumWeightLimit;
    private ArrayList<Suitcase> suitcases = new ArrayList<Suitcase>();
    private int currentWeight;

    public Container(int maxWeightC){
        this.maximumWeightLimit = maxWeightC;
    }

    public void addSuitcase(Suitcase suitcase) {
        this.currentWeight += suitcase.totalWeight();
        if (this.currentWeight <= this.maximumWeightLimit) {
            this.suitcases.add(suitcase);
        } else {
            this.currentWeight -= suitcase.totalWeight();
        }
    }

    public String toString(){
        return this.suitcases.size()+" suitcases ("+this.currentWeight+" kg)";
    }

    public void printThings(){
        for (Suitcase eachSuitcase : this.suitcases){
            eachSuitcase.printThings();
        }
    }
}
