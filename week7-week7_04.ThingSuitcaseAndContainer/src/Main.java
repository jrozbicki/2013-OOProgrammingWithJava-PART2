import java.util.SimpleTimeZone;

public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!


        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);

    }

    public static void addSuitcasesFullOfBricks(Container container){
        for(int i = 0; i<100;i++) {
            Suitcase suitcase1 = new Suitcase(i+1);
            Thing thing1 = new Thing("brick", i+1);
            suitcase1.addThing(thing1);
            container.addSuitcase(suitcase1);
        }
    }
}
