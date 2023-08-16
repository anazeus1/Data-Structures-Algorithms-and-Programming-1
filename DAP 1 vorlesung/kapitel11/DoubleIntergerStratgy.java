//Example of a strategy to double the value of each individual element in a list of Integer objects
public class DoubleIntergerStratgy extends DoubleLinkedList.SubtituteStrategy {
    public Object subtitute(Object ref) {
        return 2 * (int) ref;// Due to the Object type of the return, the int value calculated in the return
                             // statement is boxed into to create a suitable integer object that is returned.
    }

}
