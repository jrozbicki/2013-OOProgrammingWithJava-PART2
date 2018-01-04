package farmsimulator;

public class MilkingRobot {
    private BulkTank tank;

    public MilkingRobot() {

    }

    public BulkTank getBulkTank(){
        if(this.tank == null){
            return null;
        } else {
            return this.tank;
        }
    }

    public void setBulkTank(BulkTank tank){
        this.tank = tank;
    }

    public void milk(Milkable milkable) throws IllegalStateException {
        if(getBulkTank()==null){
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        } else {
            this.tank.addToTank(milkable.milk());
        }
    }
}
