package people;

public class Student extends Person {
    private int credit;

    public Student(String name, String adress){
        super(name, adress);
        this.credit = 0;
    }

    public void study(){
        this.credit++;
    }

    public int credits(){
        return this.credit;
    }

    public String toString(){
        return super.toString()+"\n"+"  credits "+this.credit;
    }

}
