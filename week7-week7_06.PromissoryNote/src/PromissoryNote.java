import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> promissoryMap = new HashMap<String, Double>();

    public PromissoryNote(){}

    public void setLoan(String toWhom, double value){
        this.promissoryMap.put(toWhom, value);
    }

    public double howMuchIsTheDebt(String whose){
        if(this.promissoryMap.containsKey(whose)) {
            return promissoryMap.get(whose);
        } else {
            return 0;
        }
    }
}
