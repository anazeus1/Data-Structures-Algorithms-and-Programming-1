public class PriorityQueue<T extends Comparable<? super T>> {
    private Object[] nodes;
    private int size;

    public PriorityQueue(int capacity) {
        if (capacity >= 0) {
            nodes = new Object[capacity + 1]; /*
                                               * ... The element at index 0 remains unused, so an additional element
                                               * must be
                                               * created.
                                               */
        } else {
            throw new IllegalStateException();
        }
        size = 0;
    }

    public void add(T content) {
        if (size < nodes.length - 1) {
            size++;
            nodes[size] = content;/* add new object at the end */
            int current = size;
            boolean stop = (current == 1);
            while (!stop) {
                int parent = current / 2;// determine predecessor
                if (parent > 0 && ((T) nodes[current]).compareTo((T) nodes[parent]) > 0) {
                    swap(current, parent);/* swap larger object to the front */
                    current = parent;
                } else {
                    stop = true;
                }
            }
        }
    }

    public T poll()/*
                    * wirft Ausnahme, falls
                    * kein Objekt im Heap
                    * 
                    */ {
        if (size >= 1) {
            T first = (T) nodes[1];
            nodes[1] = nodes[size];/* letztes Objekt nach vorne */
            nodes[size] = null;
            size--;
            heapify();/*
                       * Heap-Bedingung herstellen
                       */
            return first;
        } else {
            throw new IllegalStateException();
        }
    }

    private void heapify() {
        int current = 1;
        int leftChild, rightChild, largerChild;
        boolean stop = false;
        while (!stop) {
            leftChild = 2 * current;// determine children
            rightChild = leftChild + 1;
            if (leftChild <= size) {// there is at least 1 child
                if (rightChild <= size) {// there is 2 children
                    if (((T) nodes[rightChild]).compareTo((T) nodes[leftChild]) > 0) {
                        largerChild = rightChild;/* Determine the older child */
                    } else {
                        largerChild = leftChild;
                    }
                } else {
                    largerChild = leftChild;
                }
                if (((T) nodes[largerChild]).compareTo((T) nodes[current]) > 0) {/*
                                                                                  * Child is older than predecessor:
                                                                                  * swap
                                                                                  */
                    swap(current, largerChild);
                    current = largerChild;
                } else {
                    stop = true;
                }
            } else {
                stop = true;// no more children
            }
        }
    }

    private void swap(int current, int into) {
        T temp = (T) nodes[current];
        nodes[current] = nodes[into];
        nodes[into] = temp;

    }

    public static <T extends Comparable<? super T>> T[] heapSort(T[] elements) {
        PriorityQueue<T> pq = new PriorityQueue<>(elements.length);
        for (T content : elements) {
            pq.add(content);
        }
        for (int i = elements.length - 1; i >= 0; i--) {
            elements[i] = pq.poll();
        }
        return elements;
    }

}