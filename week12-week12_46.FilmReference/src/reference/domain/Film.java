package reference.domain;

public class Film {
    private String name;

    public Film(String name){
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

        Film compared = (Film) obj;

        if(this.name == null || !this.name.equals(compared.getName())){
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
