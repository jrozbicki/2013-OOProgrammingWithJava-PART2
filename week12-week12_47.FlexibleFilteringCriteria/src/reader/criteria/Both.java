package reader.criteria;

public class Both implements Criterion {
    private Criterion crit1;
    private Criterion crit2;

    public Both(Criterion crit1, Criterion crit2){
        this.crit1 = crit1;
        this.crit2 = crit2;
    }

    @Override
    public boolean complies(String line) {
        if (crit1.complies(line) && crit2.complies(line)) {
            return true;
        } else {
            return false;
        }
    }
}
