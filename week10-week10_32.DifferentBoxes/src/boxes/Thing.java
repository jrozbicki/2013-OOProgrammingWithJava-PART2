package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        if(weight<0){
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.weight = weight;
        }
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.name == null){
            return false;
        }

        if(this.getClass() != obj.getClass()){
            return false;
        }

        Thing thing = (Thing) obj;
        if(this.name != ((Thing) obj).name){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if(this.name == null){
            return 13;
        }
        return this.name.hashCode();
    }
}
