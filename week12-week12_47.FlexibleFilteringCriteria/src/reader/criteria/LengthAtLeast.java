package reader.criteria;

public class LengthAtLeast implements Criterion {
    private int lenght;

    public LengthAtLeast(int lenght) {
        this.lenght = lenght;
    }

    @Override
    public boolean complies(String line) {
        if (line.length() >= lenght) {
            return true;
        } else {
            return false;
        }
    }
}
