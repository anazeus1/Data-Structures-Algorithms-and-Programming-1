public class RemoveSmallerThanPredStrategy extends DoublyLinkedList.DeletionStrategy<Integer> {
    int predValue;
    boolean isFirst;

    public RemoveSmallerThanPredStrategy() {
        isFirst = true;
        predValue = 0;

    }

    public boolean select(Integer ref) {
        if (!isFirst) {
            if (ref < predValue) {
                predValue = ref;
                return true;

            }
            predValue = ref;
            return false;

        } else {
            isFirst = false;
            predValue = ref;
            return false;

        }

    }

}
