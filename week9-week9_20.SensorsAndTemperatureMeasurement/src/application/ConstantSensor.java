package application;

public class ConstantSensor implements Sensor {
    private int parameter;

    public ConstantSensor(int parameter) {
        this.parameter = parameter;
    }

    @Override
    public void off() {}

    @Override
    public void on() {}

    @Override
    public int measure() {
        return this.parameter;
    }

    @Override
    public boolean isOn() {
        return true;
    }
}
