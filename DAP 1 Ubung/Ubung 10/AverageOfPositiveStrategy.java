public class AverageOfPositiveStrategy extends DoublyLinkedList.InspectionStrategy<Integer> {
    private int summ, avg, count;

    public AverageOfPositiveStrategy() {
        summ = 0;
        avg = 0;
        count = 0;

    }

    public void inspect(Integer ref) {
        if (ref > 0) {

            summ += ref;
        }
        count++;

    }

    public double getAverageOfPositive() {
        return (double) summ / count;
    }
}