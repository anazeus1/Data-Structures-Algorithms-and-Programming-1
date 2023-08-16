public class AllToAbsStrategy extends DoublyLinkedList.SubstitutionStrategy<Integer> {
    public Integer substitute(Integer ref) {
        return Math.abs(ref);

    }

}
