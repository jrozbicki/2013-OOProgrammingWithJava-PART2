package farmsimulator;

import java.util.ArrayList;
import java.util.LinkedList;

public class Farm implements Alive {
    private String owner;
    private Barn barn;
    private LinkedList<Cow> cows;

    public Farm(String owner, Barn barn){
        this.owner = owner;
        this.barn = barn;
        this.cows = new LinkedList<Cow>();
    }

    public void installMilkingRobot(MilkingRobot robot){
        robot.setBulkTank(this.barn.getBulkTank());
    }

    @Override
    public void liveHour() {
        for (Cow each : cows){
            each.liveHour();
        }
    }

    public String getOwner() {
        return owner;
    }

    public void addCow(Cow cow){
        cows.add(cow);
    }

    public void manageCows(){
        this.barn.takeCareOf(this.cows);
    }

    @Override
    public String toString(){
        if(cows.isEmpty()){
            String emptyCows = "Farm owner: "+getOwner()+"\n"+"Barn bulk tank: "+this.barn.getBulkTank()+"\n"+"No cows.";
            return emptyCows;
        } else {
            String allAnimals = "Farm owner: "+getOwner()+"\n"+"Barn bulk tank: "+this.barn.getBulkTank()+"\n"+"Animals:\n";
            for (Cow each: cows){
                allAnimals+=("        "+each.toString()+"\n");
            }
            return allAnimals;
        }
    }


}
