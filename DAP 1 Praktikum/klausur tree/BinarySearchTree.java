public class BinarySearchTree<T extends Comparable<T>>
        implements Iterable<T>// The iterator is always provided via the same method
{
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
            if (content.compareTo(t) > 0) {
                leftChild.add(t);
            } else if (content.compareTo(t) < 0) {
                rightChild.add(t);
            }
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

    private class StackBasedIterator implements Iterator<T> {
        private Stack<BinarySearchTree<T>> nodes;

        public StackBasedIterator() {
            nodes = new Stack<BinarySearchTree<T>>();
            descendLeftAndPush(BinarySearchTree.this);
        }

        public T next() {
            if (hasNext()) {
                T content = nodes.peek().getContent();
                descendLeftAndPush(nodes.pop().rightChild);
                return content;
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean hasNext() {
            return !nodes.isEmpty();
        }

        private void descendLeftAndPush(BinarySearchTree<T> root) {
            BinarySearchTree<T> current = root;
            while (!current.isEmpty()) {
                nodes.push(current);
                current = current.leftChild;
            }
        }

    }

    public Iterator<T> iterator() {
        return new StackBasedIterator();
    }

    // aufgabe 1
    public int countNodes(int top, int bottom) {
        if (top <= bottom && !isEmpty()) {
            if (bottom >= 0 && top <= 0) {
                return 1 + leftChild.countNodes(top - 1, bottom - 1) + rightChild.countNodes(top - 1, bottom - 1);
            }

            else {
                return leftChild.countNodes(top - 1, bottom - 1) + rightChild.countNodes(top - 1, bottom - 1);
            }

        }

        else {
            return 0;
        }

    }

    // Aufgabe 2
    public int sortedUpto(int n) {
        if (n > 0 && !isEmpty()) {// seems funky

            int b = leftChild.sortedUpto(n);
            if (b > 0) {
                System.out.println(content.toString());
            }
            if ((b - 1) > 0) {
                int c = rightChild.sortedUpto(b - 1);
                return c;
            }

            return 0;

        } else {
            return n;
        }
    }

    // aufgabe 3
    public T largestTo(int level) {
        if (!isEmpty() && level >= 0) {
            if (level == 0) {
                return getContent();

            } else {
                T a = leftChild.largestTo(level - 1);
                T b = rightChild.largestTo(level - 1);
                if (a != null && b != null) {// is this efficient or is there otherr solution
                    if (a.compareTo(b) > 0) {
                        return a;
                    } else {
                        return b;
                    }

                } else if (a != null) {// this too
                    return a;
                }
                return b;

            }

        } else {
            return null;
        }
    }

    // Aufgabe 4
    public int isNiceTree() {
        if (isEmpty()) {
            return 0;

        } else {
            if (isLeaf()) {
                return 1;
            } else {
                int a = leftChild.isNiceTree();
                int b = rightChild.isNiceTree();
                if (a < 0 || b < 0) {
                    return -1;
                } else if (Math.abs(a - b) <= 1) {
                    return a + b;
                } else {// i think one else is not necessary
                    return -1;

                }
            }

        }
    }

    // Aufgabe 5
    public int countNodesImpair(int level) {
        if (!isEmpty()) {
            if (level % 2 == 1) {
                return 1 + rightChild.countNodesImpair(level + 1) + leftChild.countNodesImpair(level + 1);
            } else {
                return rightChild.countNodesImpair(level + 1) + leftChild.countNodesImpair(level + 1);
            }

        } else {
            return 0;
        }

    }

    // aufgabe6
    public boolean smallerExist(T obj) {
        if (!isEmpty()) {
            if (getContent() != null) {
                if (getContent().compareTo(obj) < 0) {
                    return true;
                } else {
                    return leftChild.smallerExist(obj) || rightChild.smallerExist(obj);
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    // Aufgabe 7
    public BinarySearchTree<T> subTree(T obj) {
        if (!isEmpty()) {
            if (getContent().compareTo(obj) == 0) {
                BinarySearchTree<T> temp = new BinarySearchTree<T>();
                temp.content = this.content;
                temp.leftChild = this.leftChild;
                temp.rightChild = this.rightChild;
                content = null;// this also
                leftChild = null;
                rightChild = null;
                return temp;
            } else {
                BinarySearchTree<T> a = leftChild.subTree(obj);
                if (a != null) { // here
                    return a;
                }
                return rightChild.subTree(obj);

            }
        } else {
            return null;
        }
    }

    // aufgabe /8
    public boolean isDirectParent(T p, T c) {
        if (!isEmpty()) {
            if (getContent().compareTo(p) == 0) {
                if (!leftChild.isEmpty()) {
                    if (leftChild.getContent().compareTo(c) == 0) {
                        return true;
                    }
                }
                if (!rightChild.isEmpty()) {
                    if (rightChild.getContent().compareTo(c) == 0) {
                        return true;
                    }
                }
                return false;
            }
            return leftChild.isDirectParent(p, c) || rightChild.isDirectParent(p, c);
        } else {
            return false;
        }

    }
}
