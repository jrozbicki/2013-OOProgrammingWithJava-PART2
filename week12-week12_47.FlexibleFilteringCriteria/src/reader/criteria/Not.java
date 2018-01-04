package reader.criteria;

public class Not implements Criterion {
    private Criterion crit;

    public Not(Criterion crit){
        this.crit = crit;
    }

    @Override
    public boolean complies(String line) {
        if (crit.complies(line)) {
            return false;
        } else {
            return true;
        }
    }
}
