//The substitute method increases the value of each element of a list of Integer objects by the increment specified in the constructor.
public class AddNStrategy extends DoubleLinkedList.SubtituteStrategy {
    private int increment;

    public AddNStrategy(int increment) {
        this.increment = increment;

    }

    public Object subtitute(Object ref) {
        return (int) ref + increment;
    }
}