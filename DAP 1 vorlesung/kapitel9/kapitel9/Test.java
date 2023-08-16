package kapitel9;

public class Test {
    public static void main(String[] args) {
        DoubleLinkedList l = new DoubleLinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        // int i = l.get(1);//cannot convert from object to int
        Object a = l.get(1);// The assignment to an Object reference is possible
                            // because Object as a superclass can refer to objects of one of its subclasses
                            // – in this case Integer.  However, only those methods that are declared in
                            // the Object class can be called via the ref reference. In particular, the int
                            // value stored in the integer object cannot be accessed.  So this solution
                            // doesn't really help.
        Integer ref = (Integer) l.get(0);
        int j = (Integer) l.get(1);
        int k = (int) l.get(1);// all correct

        // sum up ints
        ForwardIterator iterator = l.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += (int) iterator.next();

        }

        // sum up last 10
        ReverseIterator reverseIterator = l.reverseIterator();
        int i = 0;
        int sum10 = 0;
        while (reverseIterator.hasNext() && i < 10) {
            sum10 += (int) reverseIterator.next();

        }
    }

}
