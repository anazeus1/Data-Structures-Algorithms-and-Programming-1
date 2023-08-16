public class SubtotalStrategy extends DoublyLinkedList.InsertionStrategy<Integer> {
    private int subtotal;

    public SubtotalStrategy() {
        subtotal = 0;
    }

    public boolean select(Integer ref) {
        return true;

    }

    public Integer toInsert(Integer ref) {
        subtotal += ref;
        return subtotal;

    }

}
