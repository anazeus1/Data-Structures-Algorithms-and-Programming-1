public class RemoveAllInIntervalStrategy extends DoublyLinkedList.DeletionStrategy<Integer> {
    private int top, bottom;

    public RemoveAllInIntervalStrategy(int bottom, int top) {
        this.top = top;
        this.bottom = bottom;
    }

    public boolean select(Integer ref) {
        return (ref <= top && ref >= bottom);

    }
}
