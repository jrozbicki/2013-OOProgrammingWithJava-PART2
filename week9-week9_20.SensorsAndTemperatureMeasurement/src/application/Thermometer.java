package application;

import java.util.Random;

public class Thermometer implements Sensor{

    private boolean state;

    public Thermometer(){
        this.state = false;
    }
    @Override
    public void on() {
        //System.out.println("on");
        this.state=true;
    }

    @Override
    public void off() {
        //System.out.println("off");
        this.state=false;
    }

    @Override
    public boolean isOn() {
        return this.state;
    }

    @Override
    public int measure() {
        if(this.state) {
            Random random =  new Random();
            int randomInt = random.nextInt(61)-30;
            System.out.println(randomInt);
            return randomInt;
        } else {
           throw new IllegalStateException();
        }

    }

}
