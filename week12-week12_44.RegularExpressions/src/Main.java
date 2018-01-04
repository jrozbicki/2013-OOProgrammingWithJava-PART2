import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write test code here
        Scanner reader = new Scanner("04:59:31");
        System.out.println("Give a string: ");
        String string = reader.nextLine();

        if (clockTime(string)) {
            System.out.println("The form is fine.");
        } else {
            System.out.println("The form is wrong.");
        }
    }

    public static boolean isAWeekDay(String string) {
        if (string.matches("mon|tue|wed|thu|fri|sat|sun")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean allVowels(String string) {
        if (string.matches("[aeouiyäö]*")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean clockTime(String string) {
        if(string.matches("[a-z]*") || string.length()!=8){
            return false;
        }
        String hh = string.substring(0, 2);
        String mm = string.substring(3, 5);
        String ss = string.substring(6, 8);

        System.out.println(hh);
        System.out.println(mm);
        System.out.println(ss);


        if (hh.matches("[0-1][0-9]|2[0-3]") && mm.matches("[0-5][0-9]") && ss.matches("[0-5][0-9]")) {
            return true;
        } else {
            return false;
        }
    }
}
