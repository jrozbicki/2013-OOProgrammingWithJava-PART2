import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args){
        List<Student> students = new ArrayList<Student>();

        Student l = new Student("Laura");
        Student r = new Student("Ricardo");
        Student a = new Student("Alejandra");
        Student v = new Student("Viviana");
        Student c = new Student("Camilo");

        students.add(l);
        students.add(r);
        students.add(a);
        students.add(v);
        students.add(c);


        System.out.println(students);
        Collections.sort(students);
        System.out.println(students);
    }
}
