package farmsimulator;

import javax.print.attribute.standard.MediaSize;
import java.util.Random;

public class Cow implements Milkable, Alive {
    private String name;
    private double amount;
    private double capacity;

    public Cow(){
        this.name = NAMES[1+new Random().nextInt(NAMES.length-1)];
        this.amount = 0;
        this.capacity = 15 + new Random().nextInt(26);
    }

    public Cow(String name){
        this.name = name;
        this.amount = 0;
        this.capacity = 15 + new Random().nextInt(26);
    }

    public String getName(){
        return this.name;
    }

    public double getCapacity(){
        return this.capacity;
    }

    public double getAmount(){
        return this.amount;
    }

    public String toString(){
        return getName()+" "+Math.ceil(getAmount())+"/"+Math.ceil(getCapacity());
    }

    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    @Override
    public void liveHour() {
        double milkAmountInHour = (double) (7+new Random().nextInt(14))/10;
        if (this.amount + milkAmountInHour >= getCapacity()){
            this.amount = getCapacity();
        } else {
            this.amount += milkAmountInHour;
        }
    }

    @Override
    public double milk() {
        double milked = this.amount;
        this.amount = 0.0;
        return milked;
    }
}
