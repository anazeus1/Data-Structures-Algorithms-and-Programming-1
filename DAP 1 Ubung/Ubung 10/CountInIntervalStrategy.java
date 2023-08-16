public class CountInIntervalStrategy extends DoublyLinkedList.InspectionStrategy<Integer> {
    private int count, bottom, top;

    public CountInIntervalStrategy(int Bottom, int Top) {
        this.top = Top;
        this.bottom = Bottom;

    }

    public void inspect(Integer ref) {
        if (ref >= bottom && ref <= top) {
            count++;

        }

    }

    public int getCount() {
        return count;
    }

}
