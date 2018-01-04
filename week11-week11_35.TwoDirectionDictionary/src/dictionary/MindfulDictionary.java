package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MindfulDictionary {
    private Map<String, String> dictionary;
    private File file;
    private Scanner fileReader;
    private FileWriter writer;


    public MindfulDictionary() {
        this.dictionary = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) throws Exception {
        this.file = new File(file);
        this.dictionary = new HashMap<String, String>();
        if (this.file.exists()) {
            this.fileReader = new Scanner(this.file, "UTF-8");

        }
    }

    public void add(String word, String translation) {
        boolean contains = false;
        for (String each : this.dictionary.keySet()) {
            if (each.equals(word)) {
                contains = true;
                break;
            }
        }
        if (!contains) {
            this.dictionary.put(word, translation);
        }
    }

    public String translate(String word) {
        if (this.dictionary.keySet().contains(word)) {
            return this.dictionary.get(word);
        } else if (this.dictionary.containsValue(word)) {
            String translation = "";
            for (String each : dictionary.keySet()) {
                if (this.dictionary.get(each).equals(word)) {
                    translation = each;
                    break;
                }
            }
            return translation;
        } else {
            return null;
        }
    }

    public void remove(String word) {
        if (this.dictionary.keySet().contains(word)) {
            this.dictionary.remove(word);
        } else if (this.dictionary.containsValue(word)) {
            String translation = "";
            for (String each : dictionary.keySet()) {
                if (this.dictionary.get(each).equals(word)) {
                    this.dictionary.remove(each);
                    break;
                }
            }
        } else {
        }
    }

    public boolean load() {
        if (file.exists()) {
            this.dictionary.clear();

            String line = "";
            String[] parts = null;

            while (fileReader.hasNextLine()) {
                line = fileReader.nextLine();
                parts = line.split(":");   // the line is split at :

                if (!this.dictionary.containsKey(parts[0]) && !this.dictionary.containsValue(parts[1])) {
                    this.dictionary.put(parts[0], parts[1]);
                }
            }
            fileReader.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean save() {
        try {
            if (file.exists()) {
            } else {
                file.createNewFile();
            }

            this.writer = new FileWriter(this.file);
            for (String each : this.dictionary.keySet()) {
                writer.write(each + ":" + this.dictionary.get(each) + "\n");
            }
            writer.close();


        } catch (IOException ex) {
            Logger.getLogger(MindfulDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (file.canWrite()) {
            return true;
        } else {
            return false;
        }

    }
}
