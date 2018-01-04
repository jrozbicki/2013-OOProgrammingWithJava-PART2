import containers.ProductContainer;
import containers.ProductContainerRecorder;
import containers.ContainerHistory;

public class Main {

    public static void main(String[] args) {
        // write test code here
// the well known way:
        ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
        juice.takeFromTheContainer(11.3);

        juice.addToTheContainer(1.0);
        juice.printAnalysis();
    }

}
