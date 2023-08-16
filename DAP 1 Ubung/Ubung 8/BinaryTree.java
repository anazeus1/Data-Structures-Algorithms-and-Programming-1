
public class BinaryTree {
    private HuffmanTriple content;
    private BinaryTree leftChild;
    private BinaryTree rightChild;

    /* make an empty tree */
    public BinaryTree() {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public void breadthFirstTraversal() {
        RingPuffer r = new RingPuffer(size());
        r.push(this);
        while (r.countElements() != 0) {
            BinaryTree current = r.pop();
            System.out.print(current.content.getletter());
            if (!current.leftChild.isEmpty()) {
                r.push(current.leftChild);
            }
            if (!current.rightChild.isEmpty()) {
                r.push(current.rightChild);
            }
        }
    }

    public int[] levelwidths() {
        int height = height();
        int[] widths = new int[height];
        levelwidths(widths, 0);
        return widths;

    }

    private void levelwidths(int[] widths, int level) {
        if (!isEmpty()) {
            if (level == widths.length - 1) {
                widths[level] += 1;

            } else {
                widths[level] += 1;
                leftChild.levelwidths(widths, level + 1);
                rightChild.levelwidths(widths, level + 1);

            }
        }

    }

    public int height() {
        if (isEmpty()) {
            return 0;
        }
        return Math.max(leftChild.height() + 1, rightChild.height() + 1);
    }

    public BinaryTree(HuffmanTriple content) {
        this.content = content;
    }

    public void add(char t) {
        if (isEmpty()) {
            /* if search finally unsuccessful - insert new node with t */
            content = new HuffmanTriple(t);
            leftChild = new BinaryTree();
            rightChild = new BinaryTree();
        } else {

            /* further insertion in the left subtree */
            if (content.getletter() > t) {
                leftChild.add(t);

                /* further insertion in the right subtree */
            } else if (content.getletter() < t) {
                rightChild.add(t);

                /*
                 * search whether a node with content t already exists, if found - increase its
                 * frequency
                 */
            } else {
                content.incrementFrequency();
            }
        }
    }

    public void iterativeAdd(char t) {
        BinaryTree current = this;
        while (!current.isEmpty() && current.content.getletter() != t) {
            if (current.content.getletter() > t) {
                current = current.leftChild;

            } else {
                current = current.rightChild;
            }
            if (current.isEmpty()) {
                current.content = new HuffmanTriple(t);
                current.leftChild = new BinaryTree();
                current.rightChild = new BinaryTree();
            } else {
                current.content.incrementFrequency();
            }
        }
    }

    public String getCode(char t) {
        if (!isEmpty()) {
            if (content.getletter() > t) {
                return leftChild.getCode(t);
            } else if (content.getletter() < t) {
                return rightChild.getCode(t);
            } else {
                return content.getCoding();
            }
        } else {
            throw new IllegalStateException();
        }

    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return leftChild.size() + rightChild.size() + 1;
        }
    }

    public boolean isEmpty() {
        return content == null;
    }

    public boolean isLeaf() {
        return leftChild.isEmpty() && rightChild.isEmpty();

    }

    public void show() {
        if (!isEmpty()) {
            leftChild.show();
            System.out.println(content.toString());
            rightChild.show();
        }
    }

    public HuffmanTriple[] toArray() {
        if (!isEmpty()) {
            HuffmanTriple[] collector = new HuffmanTriple[size()];
            toArray(collector, 0);
            return collector;
        }
        return new HuffmanTriple[0];
    }

    private int toArray(HuffmanTriple[] collector, int index) {
        if (!isEmpty()) {
            index = leftChild.toArray(collector, index);
            collector[index] = content;
            index = rightChild.toArray(collector, index + 1);
        }
        return index;
    }

    private BinaryTree biggestInleft() {

        BinaryTree current = this.leftChild;
        while (!current.isLeaf()) {
            current = current.rightChild;

        }
        return current;
    }

    public void delete() {
        BinaryTree a = biggestInleft();
        if (!a.isEmpty()) {
            content = a.content;
            a.content = a.leftChild.content;
            a.leftChild = a.leftChild.leftChild;
            a.rightChild = a.leftChild.rightChild;

        } else {
            content = rightChild.content;
            rightChild = rightChild.rightChild;
            leftChild = rightChild.leftChild;

        }

    }

    public boolean completePath() {
        if (isLeaf() || isEmpty()) {
            return true;
        } else if (!rightChild.isEmpty() && !leftChild.isEmpty()) {
            return leftChild.completePath() || rightChild.completePath();

        }
        return false;

    }

}