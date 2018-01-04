package reference.domain;

public class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(this.getClass() != obj.getClass()){
            return false;
        }

        Person compared = (Person) obj;

        if(this.name == null || !this.name.equals(compared.getName())){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        if(this.name == null){
            return 7;
        }

        return this.name.hashCode();
    }
}
