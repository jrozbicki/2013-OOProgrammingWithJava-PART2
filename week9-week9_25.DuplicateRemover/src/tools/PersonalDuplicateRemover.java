package tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String> list;
    private int counter;

    public PersonalDuplicateRemover() {
        this.list = new HashSet<String>();
        this.counter = 0;
    }

    @Override
    public void add(String characterString) {
        if (!this.list.contains(characterString)) {
            this.list.add(characterString);
        } else {
            this.counter++;
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.counter;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.list;
    }

    @Override
    public void empty() {
        this.list.clear();
        this.counter = 0;
    }
}
