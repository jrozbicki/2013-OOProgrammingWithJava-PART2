import validation.Calculator;
import validation.Person;

public class Main {

    public static void main (String[] args) {
        Person person = new Person("name", 121);
        Calculator calc = new Calculator();

        calc.multiplication(-1);
        calc.binomialCoefficient(20, 21);
    }
}
