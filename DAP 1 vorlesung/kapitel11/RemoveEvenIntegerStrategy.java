public class RemoveEvenIntegerStrategy extends DoubleLinkedList.DeletionStrategy {
    public boolean select(Object ref) {
        if ((int) ref % 2 == 0) {
            return true;
        }
        return false;

    }

}
