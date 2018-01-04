public class Thing {
    private String name;
    private int weight;

    public Thing(String nameC, int weightC){
        this.name = nameC;
        this.weight = weightC;
    }

    public String getName(){
        return this.name;
    }

    public int getWeight(){
        return this.weight;
    }

    public String toString(){
        return this.name+" ("+this.weight+" kg)";
    }

}
