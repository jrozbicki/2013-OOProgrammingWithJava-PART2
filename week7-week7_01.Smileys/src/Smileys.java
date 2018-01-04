
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
         printWithSmileys("Method");
         printWithSmileys("Beerbottle");
         printWithSmileys("Interface");
    }

    private static void printWithSmileys(String characterString){
        String smile = ":)";
        if (characterString.length()%2 == 1){
            characterString+=" ";
        }
        int howMuchSmiles = (characterString.length()+6)/2;

        for (int i = 0; i<howMuchSmiles; i++){
            System.out.print(smile);
        }
        System.out.println("");
        System.out.println(":) "+characterString+" :)");

        for (int a = 0; a<howMuchSmiles; a++){
            System.out.print(smile);
        }
        System.out.println("");
    }
}
