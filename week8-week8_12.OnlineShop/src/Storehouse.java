import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Storehouse {

    private Map<String, Integer> listOfPrices = new HashMap<String, Integer>();
    private Map<String, Integer> listOfStocks = new HashMap<String, Integer>();


    public void addProduct(String product, int price, int stock) {
        listOfPrices.put(product, price);
        listOfStocks.put(product, stock);


    }

    public int price(String product) {
        if(listOfPrices.containsKey(product)) {
            return listOfPrices.get(product);
        } else {
            return -99;
        }
    }

    public int stock(String product) {
        if (listOfStocks.containsKey(product)) {
            return listOfStocks.get(product);
        } else {
            return 0;
        }
    }

    public boolean take(String product) {
        if(listOfStocks.containsKey(product) && listOfStocks.get(product)>0){
            listOfStocks.replace(product,listOfStocks.get(product),listOfStocks.get(product)-1);
            return true;
        }
        return false;
    }

    public Set<String> products(){
        Set<String> productsSet = new HashSet<String>();
        for (String each : listOfPrices.keySet()){
            productsSet.add(each);
        }
        return productsSet;
    }


}
