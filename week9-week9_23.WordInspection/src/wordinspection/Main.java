package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception{
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        WordInspection inspector = new WordInspection(file);

        System.out.println("Number of words: "+inspector.wordCount());
        System.out.println("L Ending list: "+inspector.wordsEndingInL());
        System.out.println("Palindromes: "+inspector.palindromes());
    }
}
