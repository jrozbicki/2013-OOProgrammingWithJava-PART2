import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary = new HashMap<String, String>();

    public String translate(String word){
        if(dictionary.containsKey(word)){
            return dictionary.get(word);
        } else {
            return null;
        }
    }

    public void add(String word, String translation){
        dictionary.put(word, translation);
    }

    public int amountOfWords(){
        return dictionary.size();
    }

    public ArrayList<String> translationList(){
        ArrayList<String> dict = new ArrayList<String>();
        for (String eachKey : dictionary.keySet()){
            dict.add(eachKey+" = "+dictionary.get(eachKey));
        }
        return dict;
    }

}
