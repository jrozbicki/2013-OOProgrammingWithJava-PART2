package reader.criteria;

import java.lang.reflect.Array;

public class AtLeastOne implements Criterion {
    private Criterion[] crit;

    public AtLeastOne(Criterion... criteria){
        this.crit = criteria;
    }

    @Override
    public boolean complies(String line) {
        for(int i=0; i<crit.length; i++){
            if(crit[i].complies(line)){
                return true;
            }
        }
        return false;
    }
}
