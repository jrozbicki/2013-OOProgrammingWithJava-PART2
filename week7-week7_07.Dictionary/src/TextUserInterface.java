import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.reader = reader;
        this.dictionary = dictionary;

    }

    public void add(){
        System.out.print("In Finnish: ");
        String finnish = reader.nextLine();
        System.out.print("Traslation: ");
        String traslation = reader.nextLine();
        dictionary.add(finnish, traslation);
    }

    public void translate(){
        System.out.print("Give a word: ");
        String toTranslate = reader.nextLine();
        System.out.println("Translation: "+dictionary.translate(toTranslate));
    }

    public void start(){

        System.out.println("Statement: ");
        System.out.println("    add - adds a word pair to the dictionary");
        System.out.println("    translate - asks a word and prints its translation");
        System.out.println("    quit - quit the text user interface");

        while (true) {
            System.out.println("");
            System.out.print("Statement: ");
            String userInput = this.reader.nextLine();
            if (userInput.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if (userInput.equals("add")) {
                add();
            } else if (userInput.equals("translate")){
                translate();
            } else {
                System.out.println("Unknown statement");
            }
        }
    }
}
