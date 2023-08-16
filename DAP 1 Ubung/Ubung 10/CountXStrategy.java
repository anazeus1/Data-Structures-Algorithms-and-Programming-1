public class CountXStrategy extends DoublyLinkedList.InspectionStrategy<Integer> {
    private int count, x;

    public CountXStrategy(int x) {
        count = 0;
        this.x = x;

    }

    public void inspect(Integer ref) {
        if (ref == x) {
            count++;

        }

    }

    public int getCount() {
        return count;
    }

}
