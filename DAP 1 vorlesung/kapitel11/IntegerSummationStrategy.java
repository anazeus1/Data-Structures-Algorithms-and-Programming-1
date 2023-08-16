//Example of a strategy that can be used to calculate the sum of all values ​​in a list of Integer objects
public class IntegerSummationStrategy extends DoubleLinkedList.InspectionStrategy {
    private int sum;

    IntegerSummationStrategy() {
        sum = 0;

    }

    public void inspect(Object ref) {
        sum += (int) ref;
    }

    public int getSum() {
        return sum;
    }
}
