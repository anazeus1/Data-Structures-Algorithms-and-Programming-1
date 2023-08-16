public class RemoveAndCountAllInIntervalStrategy extends DoublyLinkedList.DeletionStrategy<Integer> {
    private int top, bottom, count;

    public RemoveAndCountAllInIntervalStrategy(int b, int t) {
        top = t;
        bottom = b;
        count = 0;
    }

    public boolean select(Integer ref) {
        if (ref >= bottom && ref <= top) {
            count++;
            return true;
        }
        return false;

    }

    public int getCount() {
        return count;
    }

}
