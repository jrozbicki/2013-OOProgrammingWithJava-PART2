package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {
    private File file;

    public Analysis(File file) {
        this.file = file;
    }

    public int lines() throws Exception {
        Scanner reader = new Scanner(this.file);
        String string = "";
        int lineCounter = 0;
        while (reader.hasNextLine()) {
            string = reader.nextLine();
            lineCounter++;
        }
        reader.close();
        return lineCounter;
    }

    public int characters() throws Exception {

        Scanner reader = new Scanner(this.file);

        String string = "";
        int charCounter = 0;

        while (reader.hasNextLine()) {
            string += reader.nextLine();

        }
        charCounter = string.length() + lines();
        reader.close();
        return charCounter;
    }


}
