package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    private List<Person> employees;

    public Employees(){
        this.employees = new ArrayList<Person>();
    }

    public void add(Person person){
        this.employees.add(person);
    }

    public void add(List<Person> persons){
        for(Person each : persons){
            this.employees.add(each);
        }
    }

    public void print(){
        Iterator<Person> iterator = this.employees.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void print(Education education){
        Iterator<Person> iterator = this.employees.iterator();

        while (iterator.hasNext()){
            Person nextPerson = iterator.next();
            if(nextPerson.getEducation().equals(education)){
                System.out.println(nextPerson);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> iterator = this.employees.iterator();

        while (iterator.hasNext()) {
            Person nextPerson = iterator.next();
            if (nextPerson.getEducation().equals(education)) {
                iterator.remove();
            }
        }
    }
}
