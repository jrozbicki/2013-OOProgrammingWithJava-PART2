package farmsimulator;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Barn {
    private BulkTank tank;


    public Barn(BulkTank tank){
        this.tank = tank;

    }

    public BulkTank getBulkTank(){
        return this.tank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot){
        milkingRobot.setBulkTank(this.tank);
    }

    public void takeCareOf(Cow cow) throws IllegalStateException{
        this.tank.addToTank(cow.milk());
    }

    public void takeCareOf(Collection<Cow> cows) throws IllegalStateException{
        for (Cow each : cows){
            this.tank.addToTank(each.milk());
        }
    }

    @Override
    public String toString() {
        return this.tank.toString();
    }
}
