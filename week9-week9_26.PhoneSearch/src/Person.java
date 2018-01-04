import java.util.*;

public class Person {
    /// ATRYBUTY OBIEKTÓW TEJ KLASY ///
    private Map<String, List<String>> personNumberMap;
    private Map<String, List<String>> personAdressMap;
    private List<String> personNumbersList;
    private List<String> personAdressList;


    /// KONTRUKTOR ///
    public Person() {
        this.personNumberMap = new HashMap<String, List<String>>();
        this.personAdressMap = new HashMap<String, List<String>>();
        this.personNumbersList = new ArrayList<String>();
        this.personAdressList = new ArrayList<String>();
    }

    /// METODY ///


    public Map<String, List<String>> getPersonNumberMap() {
        return this.personNumberMap;
    }

    public void setPersonNumberMap(String name, String number) {
        this.personNumbersList.add(number);
        this.personNumberMap.put(name, this.personNumbersList);
    }

    public Map<String, List<String>> getPersonAdressMap() {
        return this.personAdressMap;
    }

    public void setPersonAdressMap(String name, String address) {
        this.personAdressList.add(address);
        this.personAdressMap.put(name, this.personAdressList);
    }

    public List<String> getPersonNumbersList() {
        return personNumbersList;
    }

    public List<String> getPersonAdressList() {
        return personAdressList;
    }

    public boolean searchKeyword(String keyword) {
        if (makeStringFromSet(this.personNumberMap.keySet()).contains(keyword)) {
            return true;
        } else if (makeStringFromSet(this.personAdressMap.keySet()).contains(keyword)) {
            return true;
        } else if (makeStringFromList(this.personNumbersList).contains(keyword)){
            return true;
        } else if (makeStringFromList(this.personAdressList).contains(keyword)) {
            return true;
        } else {
            return false;
        }
    }

    public String makeStringFromSet(Set<String> keySet){
        String stringSet = "";
        for (String each : keySet){
            stringSet+=" "+each;
        }
        return stringSet;
    }

    public String makeStringFromList(List<String> list){
        String stringList = "";
        for (String each : list){
            stringList+=each;
        }
        return stringList;
    }

    public List<String> sortKeysList(){
        List<String> allKeys = new ArrayList<String>();
        for(String each : this.getPersonNumberMap().keySet()){
            allKeys.add(each);
        }
        for (String each : this.getPersonAdressMap().keySet()){
            allKeys.add(each);
        }
        Collections.sort(allKeys);
        return allKeys;
    }
}
