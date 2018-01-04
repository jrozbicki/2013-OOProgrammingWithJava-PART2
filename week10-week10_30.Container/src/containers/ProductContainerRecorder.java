package containers;

public class ProductContainerRecorder extends ProductContainer {
    private ContainerHistory CH;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume){
        super(productName, capacity);
        super.addToTheContainer(initialVolume);
        this.CH = new ContainerHistory();
        this.CH.add(initialVolume);
    }

    @Override
    public void addToTheContainer(double amount){
        super.addToTheContainer(amount);
        this.CH.add(super.getVolume());
    }

    public double takeFromTheContainer(double amount){
        double buffer = super.takeFromTheContainer(amount);
        this.CH.add(super.getVolume());
        return buffer;
    }

    public void printAnalysis(){
        System.out.println("Product: "+this.getName());
        System.out.println("History: "+this.CH.toString());
        System.out.println("Greatest product amount: "+this.CH.maxValue());
        System.out.println("Smallest product amount: "+this.CH.minValue());
        System.out.println("Average: "+this.CH.average());
        System.out.println("Greatest change: "+this.CH.greatestFluctuation());
        System.out.println("Variance: "+this.CH.variance());
    }

    public String history(){
        return this.CH.toString();
    }
}
