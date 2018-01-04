package farmsimulator;

public class BulkTank {
    private double capacity;
    private double volume;

    public BulkTank() {
        this.capacity = 2000.0;
        this.volume = 0;
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return this.volume;
    }

    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }

    public void addToTank(double amount) {
        if (amount >= howMuchFreeSpace()) {
            this.volume = this.capacity;
        } else {
            this.volume += amount;
        }
    }

    public double getFromTank(double amount) {
        if (amount > getVolume()) {
            amount = getVolume();
        }
        this.volume -= amount;

        return amount;
    }

    @Override
    public String toString() {
        return Math.ceil(this.getVolume()) + "/" + Math.ceil(this.getCapacity());
    }

}
