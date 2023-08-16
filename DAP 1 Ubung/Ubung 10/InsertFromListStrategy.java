public class InsertFromListStrategy extends DoublyLinkedList.InsertionStrategy<Integer> {
    private DoublyLinkedList<Integer> list;

    public InsertFromListStrategy(DoublyLinkedList<Integer> list) {
        this.list = list;

    }

    public boolean select(Integer ref) {
        return true;
    }

    public Integer toInsert(Integer ref) {
        if (list.getFirst() != null) {
            return list.removeFirst();

        } else {
            throw new IllegalStateException();

        }

    }

}
