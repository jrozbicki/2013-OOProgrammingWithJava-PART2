import java.util.*;

public class PhoneAndAdressBook {

    /// ATRYBUTY OBIEKTÓW TEJ KLASY ///
    private ArrayList<Person> fullListOfData;
    private Scanner reader;


    /// KONTRUKTOR ///
    public PhoneAndAdressBook(Scanner reader) {
        this.fullListOfData = new ArrayList<Person>();
        this.reader = reader;
    }

    /// METODY ///


    public void addNumberToPerson() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();

        /// Sprawdzanie czy osoba jest już w książce ///
        boolean ifContainsPersonName = false;
        for (Person each : fullListOfData) {
            /// Jeśli znaleziono osobę w książce
            if (each.getPersonNumberMap().containsKey(name) || each.getPersonAdressMap().containsKey(name)) {
                ifContainsPersonName = true;
                each.getPersonNumbersList().add(number);
                each.getPersonNumberMap().put(name, each.getPersonNumbersList());
                break;
            }
        }
        /// Jeśli nie znaleziono osoby w książce
        if (!ifContainsPersonName) {
            Person obj = new Person();
            obj.setPersonNumberMap(name, number);
            fullListOfData.add(obj);
        }

    }

    public void searchNumberByPerson() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        boolean ifContainsPerson = false;
        /// Przeglądanie obiektów Person w poszukiwaniu klucza Map == wpisanemu imieniu///
        for (Person each : fullListOfData) {
            /// Jeśli znaleziono ///
            if (each.getPersonNumberMap().containsKey(name)) {
                ifContainsPerson = true;
                for (String eachNumber : each.getPersonNumbersList()) {
                    System.out.println(" " + eachNumber);
                }
                break;
            }
        }
        /// Jeśli nie znaleziono osoby w książce ///
        if (!ifContainsPerson) {
            System.out.println("  not found");
        }
    }

    public void searchPersonByNumber() {
        System.out.print("number: ");
        String number = this.reader.nextLine();
        boolean ifContainsNumber = false;
        /// Przeglądanie obiektów Person w poszukiwaniu Value == number///
        for (Person each : fullListOfData) {
            /// Jeśli znaleziono
            if (each.getPersonNumbersList().contains(number)) {
                ifContainsNumber = true;
                Set<String> name = each.getPersonNumberMap().keySet();
                for (String eachName : name) {
                    System.out.println(" " + eachName);
                }
                break;
            }
        }
        /// Jeśli nie znaleziono numeru ///
        if (!ifContainsNumber) {
            System.out.println("  not found");
        }
    }

    public void addAddress() {
        System.out.print("whose address: ");
        String name = this.reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();
        String address = street + " " + city;

        /// Sprawdzanie czy osoba jest już w książce ///
        boolean ifContainsPersonName = false;
        for (Person each : fullListOfData) {
            /// Jeśli znaleziono osobę w książce
            if (each.getPersonAdressMap().containsKey(name) || each.getPersonNumberMap().containsKey(name)) {
                ifContainsPersonName = true;
                each.getPersonAdressList().add(address);
                each.getPersonAdressMap().put(name, each.getPersonAdressList());
                break;
            }
        }
        /// Jeśli nie znaleziono osoby w książce
        if (!ifContainsPersonName) {
            Person obj = new Person();
            obj.setPersonAdressMap(name, address);
            fullListOfData.add(obj);
        }
    }

    public void giveInfo(String name) {
        /// Sprawdzanie czy list jest pusta lub czy obiektu nie ma na obu mapach ///
        if (isEmpty() || notContainName(name)) {
            System.out.println(" not found");
        } else {
            boolean ifContainsPersonAdress = false;
            /// Przeglądanie obiektów Person w poszukiwaniu osoby do wydrukowania adresów///
            for (Person each2 : fullListOfData) {
                /// Jeśli znaleziono ///
                if (each2.getPersonAdressMap().containsKey(name)) {
                    ifContainsPersonAdress = true;
                    System.out.print("  address: ");
                    for (String eachAdress : each2.getPersonAdressList()) {
                        System.out.println(eachAdress);
                    }
                    break;
                }
            }
            /// Jeśli nie znaleziono osoby w książce ///
            if (!ifContainsPersonAdress) {
                System.out.println("  address unknown");
            }
            boolean ifContainsPersonNumber = false;
            /// Przeglądanie obiektów Person w poszukiwaniu osoby do wydrukowania numerów///
            for (Person each3 : fullListOfData) {
                /// Jeśli znaleziono ///
                if (each3.getPersonNumberMap().containsKey(name)) {
                    ifContainsPersonNumber = true;
                    System.out.println("  phone numbers:");
                    for (String eachNumber : each3.getPersonNumbersList()) {
                        System.out.println("   " + eachNumber);
                    }
                    break;
                }
            }
            /// Jeśli nie znaleziono osoby w książce ///
            if (!ifContainsPersonNumber) {
                System.out.println("  phone number not found");
            }
        }
    }

    public boolean isEmpty() {
        if (fullListOfData.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean notContainName(String name) {
        boolean ifNotContainsBoth = true;
        for (Person each : fullListOfData) {
            if (each.getPersonAdressMap().containsKey(name) || each.getPersonNumberMap().containsKey(name)) {
                ifNotContainsBoth = false;
            }
        }
        if (ifNotContainsBoth) {
            return true;
        } else {
            return false;
        }
    }


    public void deletePersonalInfo() {
        System.out.print("whose information: ");
        String name = this.reader.nextLine();

        /// Usunięcie obiektu zawierającego ///
        for (Person each : fullListOfData) {
            if (each.getPersonNumberMap().containsKey(name) || each.getPersonAdressMap().containsKey(name)) {
                fullListOfData.remove(each);
                break;
            }
            if (fullListOfData.isEmpty()) {
                break;
            }

        }
    }

    public void searchByString() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = this.reader.nextLine();

        ArrayList<String> allNames = new ArrayList<String>();
        for (Person each : fullListOfData) {
            Set<String> nameNumber = each.getPersonNumberMap().keySet();
            Set<String> nameAdress = each.getPersonAdressMap().keySet();
            for (String eachName : nameNumber) {
                allNames.add(eachName);
            }
            for (String eachName2 : nameAdress) {
                allNames.add(eachName2);
            }
        }
        if (keyword.equals("")) {
            Collections.sort(allNames);
            for (String each : allNames) {
                System.out.println("");
                System.out.println(each);
                giveInfo(each);
            }
        } else {
            /// gdy szukamy konkretnej nazwy ///
            boolean ifNotFound = false;
            ArrayList<String> printOrder = new ArrayList<String>();
            for (Person each : fullListOfData) {
                if (each.searchKeyword(keyword)) {
                    ifNotFound = true;
                    String nameOfAdress = "";
                    String nameOfNumber = "";
                    for (String each5 : each.getPersonAdressMap().keySet()){
                        nameOfAdress+=""+each5;
                    }
                    for (String each6 : each.getPersonNumberMap().keySet()){
                        nameOfNumber+=""+each6;
                    }
                    if (allNames.contains(nameOfAdress)) {
                        printOrder.add(nameOfAdress);
                    } else if (allNames.contains(nameOfNumber)) {
                        printOrder.add(nameOfNumber);
                    }
                }
            }
            if (!ifNotFound) {
                System.out.println(" keyword not found");
            }
            Collections.sort(printOrder);
            for (String eachNameOfThis : printOrder){
                System.out.println("");
                System.out.println(" "+eachNameOfThis);
                giveInfo(eachNameOfThis);
            }
        }
    }
}
