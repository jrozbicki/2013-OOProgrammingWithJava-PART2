package dictionary;

import java.util.*;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String, Set<String>> dict;
    private String word;
    private Set<String> translates;

    public PersonalMultipleEntryDictionary() {
        this.dict = new HashMap<String, Set<String>>();
    }

    @Override
    public void add(String word, String entry) {
        if (this.dict.containsKey(word)) {
            this.dict.get(word).add(entry);
        } else {
            Set<String> newTranslates = new HashSet<String>();
            newTranslates.add(entry);
            this.dict.put(word,newTranslates);
        }
    }

    @Override
    public Set<String> translate(String word) {
        if (this.dict.containsKey(word)) {
            return this.dict.get(word);
        } else {
            return null;
        }
    }

    @Override
    public void remove(String word) {
        this.dict.remove(word);
    }
}
