public class SubtotalOfThree extends DoublyLinkedList.InsertionStrategy<Integer> {
    private int subtotal, count;

    public SubtotalOfThree() {
        count = 0;
        subtotal = 0;
    }

    public boolean select(Integer ref) {
        if (count % 3 == 2) {
            subtotal += ref;
            count++;
            return true;
        }
        count++;
        subtotal += ref;
        return false;
    }

    public Integer toInsert(Integer ref) {
        int temp = subtotal;
        subtotal = 0;
        return temp;

    }

}
