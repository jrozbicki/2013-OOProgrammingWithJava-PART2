package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainerHistory {
    private List<Double> history;

    public ContainerHistory(){
        this.history = new ArrayList<Double>();
    }

    public void add(double situation){
        this.history.add(situation);
    }

    public void reset(){
        this.history.clear();
    }

    public double maxValue(){
        if(history.isEmpty()){
            return 0;
        }
        return Collections.max(history);
    }

    public double minValue(){
        if(history.isEmpty()){
            return 0;
        }
        return Collections.min(history);
    }

    public double average(){
        if(history.isEmpty()){
            return 0;
        }
        double sum = 0;
        for(Double each : history){
            sum += each;
        }
        double average = sum/history.size();
        return average;
    }

    public double greatestFluctuation(){
        if(history.isEmpty() || history.size()==1){
            return 0;
        }
        double greatestFluct = 0;
        for (int i = 1; i < history.size(); i++){
            double fluct = Math.abs(history.get(i-1)-history.get(i));
            if(fluct>greatestFluct){
                greatestFluct = fluct;
            }
        }
        return greatestFluct;

    }

    public double variance(){
        if(history.isEmpty() || history.size()==1){
            return 0;
        }
        double sum = 0;
        double variance = 0;
        for (Double each : history){
            sum += Math.pow((each - average()),2.0);
        }
        variance = sum / (history.size()-1);
        return variance;
    }

    public String toString(){
        return history.toString();
    }
}
