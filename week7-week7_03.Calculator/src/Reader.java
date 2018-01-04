import java.util.Scanner;

public class Reader {
    private Scanner reader = new Scanner(System.in);

    public String readString(){
        String stringReader = reader.nextLine();
        return stringReader;
    }
    public int readInteger() {
        int integerReader = Integer.parseInt(reader.nextLine());
        return integerReader;
    }
}
