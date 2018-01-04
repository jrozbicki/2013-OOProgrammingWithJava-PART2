package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Integer> reads;
    private ArrayList<Sensor> sensors;


    public AverageSensor() {
        this.reads = new ArrayList<Integer>();
        this.sensors = new ArrayList<Sensor>();
    }

    @Override
    public void off() {
        for ( Sensor each : this.sensors){
            each.off();
        }
    }

    @Override
    public int measure() {
        if (!sensors.isEmpty() && this.isOn()) {
            int sum = 0;
            for (Sensor each : sensors) {
                sum += each.measure();
            }
            this.reads.add(sum / sensors.size());
            return sum / sensors.size();
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean isOn() {
        boolean allON = false;
        for (Sensor each : this.sensors){
            if(each.isOn()){
                allON = true;
            } else {
                allON = false;
                break;
            }

        }
        return allON;
    }


    @Override
    public void on() {
        for(Sensor each : this.sensors){
            each.on();
        }
    }

    public void addSensor(Sensor additional) {
         this.sensors.add(additional);
    }

    public List<Integer> readings(){
        return this.reads;
    }


}
