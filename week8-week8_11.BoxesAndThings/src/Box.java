import java.util.ArrayList;

public class Box implements ToBeStored {
    private double maxCapacity;

    private ArrayList<ToBeStored> boxList = new ArrayList<ToBeStored>();

    public Box(double maxCapacity){
        this.maxCapacity = maxCapacity;
    }

    public void add(ToBeStored object){
        if (object.weight()+this.weight()<maxCapacity) {
            boxList.add(object);

        }
    }

    @Override
    public double weight() {
        double weight = 0;
        for (ToBeStored each : boxList){
            weight+=each.weight();
        }
        return weight;
    }

    @Override
    public String toString(){
        return "Box: "+boxList.size()+" things, total weight "+this.weight()+" kg";
    }
}
