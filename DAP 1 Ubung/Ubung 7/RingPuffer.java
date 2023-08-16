import javax.swing.text.html.parser.Element;

public class RingPuffer {

    private BinaryTree[] BinaryTrees;
    private int readPos, writePos;
    private int nbElements;

    public RingPuffer(int n) {
        BinaryTrees = new BinaryTree[n];
        readPos = 0;
        writePos = 0;
    }

    public BinaryTree pop() {
        if (nbElements > 0) {
            BinaryTree temp = BinaryTrees[readPos];
            BinaryTrees[readPos] = null;
            readPos = (readPos + 1) % BinaryTrees.length;
            nbElements--;
            return temp;
        } else {
            throw new IllegalStateException();
        }

    }

    public BinaryTree peek() {
        if (nbElements > 0) {
            return BinaryTrees[readPos];
        } else {
            throw new RuntimeException();
        }
    }

    public void push(BinaryTree s) {
        if (nbElements < BinaryTrees.length) {

            BinaryTrees[writePos] = s;
            writePos = (writePos + 1) % BinaryTrees.length;
            nbElements++;
        } else {
            throw new IllegalStateException();
        }

    }

    public int size() {
        return BinaryTrees.length;

    }

    public int countElements() {
        return nbElements;

    }
}