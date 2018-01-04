package dictionary;

public class Main {
    public static void main(String[] args) throws Exception {
        // Test your dictionary here
        MindfulDictionary s = new MindfulDictionary("test/tmp/tmp56488.txt");
        s.add("tietokone", "computer");
        System.out.println(s.save());
    }
}
