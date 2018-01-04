import java.io.File;
import java.util.Scanner;

public class Printer {
    private String filename;

    public Printer(String fileName) throws Exception {
        this.filename = fileName;

    }

    public void printLinesWhichContain(String word) throws Exception{
        File filename = new File(this.filename);
        Scanner reader = new Scanner(filename);

        String buffer = "";
        String line = "";

        while(reader.hasNextLine()){
            line = reader.nextLine();

            if(line.contains(word)){
                buffer+= line;
                buffer += "\n";
                System.out.println(line);
            }
        }


    }

}
