
/*– The values ​​of a type passed as a type argument must have an order relation. 
– It must be possible to determine the order within the BinarySearchTree class:
 A type passed as a type argument must have suitable methods. Type parameter T Declaration of generic class F*/

public class BinarySearchTree<T extends Comparable<T>> /*
                                                        * Only a type that specializes the Comparable<T> class, i.e. has
                                                        * a compareTo method, is now permitted as an argument for the
                                                        * type parameter T
                                                        */ {
    private T content;
    private BinarySearchTree<T> leftChild, rightChild;

    public BinarySearchTree() {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public T getContent() {
        if (!isEmpty()) {
            return content;
        } else {
            throw new RuntimeException();
        }
    }

    public boolean isEmpty() {
        return content == null;
    }

    public boolean isLeaf() {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void add(T t) {
        if (isEmpty()) {
            content = t;
            leftChild = new BinarySearchTree<T>();
            rightChild = new BinarySearchTree<T>();
        } else {
            if (content.compareTo(t) > 0) {/*
                                            * content is a reference to T, T must specialize Comparable, so it has a
                                            * compareTo method
                                            */
                leftChild.add(t);
            } else if (content.compareTo(t) < 0) {
                rightChild.add(t);
            }
            // The general content search tree declared here does not have any specific
            // functionality as was the case with the CharacterSearchTree class: quantity++
        }
    }

    public boolean contains(T t) {
        if (isEmpty()) {
            return false;
        } else {
            if (content.compareTo(t) > 0) {
                return leftChild.contains(t);
            } else if (content.compareTo(t) < 0) {
                return rightChild.contains(t);
            }
            return true;
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return 1 + leftChild.size() + rightChild.size();
        }
    }

    public void show() {
        if (!isEmpty()) {
            leftChild.show();
            System.out.println(content);
            rightChild.show();
        }
    }

    public Iterator<T> listBasedIterator() {
        DoublyLinkedList<T> list = new DoublyLinkedList<T>();
        toList(list);
        return list.iterator();
    }

    private void toList(DoublyLinkedList<T> list) {
        if (!isEmpty()) {
            leftChild.toList(list);
            list.add(content);
            rightChild.toList(list);
        }
    }

    private class StackBasedIterator extends Iterator<T> {
        // The nodes of a binary search tree are to be placed on the stack. Therefore,
        // the type argument must be BinarySearchTree<T>.
        private Stack<BinarySearchTree<T>/* type argumet */> nodes;

        public StackBasedIterator() {
            nodes = new Stack<BinarySearchTree<T>>();
            /*
             * The descendLeftAndPush method looks at all nodes that are on the leftmost
             * path and places them on the nodes stack. This allows them to be easily
             * retrieved in reverse order for editing.
             */
            descendLeftAndPush(BinarySearchTree.this);
        }

        public T next() {
            if (hasNext()) {
                T content = nodes.peek().getContent();//Select node from stack and secure content
                descendLeftAndPush(nodes.pop().rightChild);//find the leftmost node in the right subtree
                return content;
            } else {
                throw new IllegalStateException();//Calling next not allowed because all content has been delivered
            }
        }

        public boolean hasNext() {
            return !nodes.isEmpty();//as long as there are nodes on the stack, iteration can continue
        }

        private void descendLeftAndPush(BinarySearchTree<T> root) {
            BinarySearchTree<T> current = root;
            while (!current.isEmpty()) {// stop when empty
                nodes.push(current);// Put on stack
                current = current.leftChild;
            }
        }

    }

    public Iterator<T> iterator() {
        return new StackBasedIterator();
    }
}
