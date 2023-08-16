public class GenericsTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<Integer>();

        ints.add(5);
        ints.add(-6);
        ints.add(7);
        ints.add(20);
        ints.add(25);
        ints.add(1);
        ints.add(-5);
        ints.add(60);
        ints.add(110);
        ints.add(29);

        ints.showAll();
        System.out.println();
        // Augabe 1 CountXStrategy
        CountXStrategy countX = new CountXStrategy(5);
        ints.inspectAll(countX);
        System.out.println("1-CountX " + countX.getCount());

        // Aufgabe 2 countInInteval
        CountInIntervalStrategy countInInterval = new CountInIntervalStrategy(6, 8);
        ints.inspectAll(countInInterval);
        System.out.println("2-CountInInterval(6,8)" + countInInterval.getCount());

        // Aufgabe 3
        AverageOfPositiveStrategy averageOfPostives = new AverageOfPositiveStrategy();
        ints.inspectAll(averageOfPostives);
        System.out.println("3-AverageOfPositives " + averageOfPostives.getAverageOfPositive());

        // Aufgabe4
        AllToAbsStrategy manip1 = new AllToAbsStrategy();
        ints.substituteAll(manip1);
        System.out.print("4-all to abs ");
        ints.showAll();

        // aufgabe 5
        AddNToPositivesStrategy manip2 = new AddNToPositivesStrategy(3);
        ints.substituteAll(manip2);
        System.out.print("5-add 3 to positives ");
        ints.showAll();

        // aufgabe 6
        DoubleAllinIntervalStrategy manip3 = new DoubleAllinIntervalStrategy(3, 9);
        ints.substituteAll(manip3);
        System.out.print("6-double all in interval 3 9 ");
        ints.showAll();

        // aufgabe 7
        RemoveAllNegatives manip4 = new RemoveAllNegatives();
        ints.deleteSelected(manip4);
        System.out.print("7-delete all negatives ");
        ints.showAll();

        // Aufgabe 8
        RemoveAllInIntervalStrategy manip5 = new RemoveAllInIntervalStrategy(15, 19);
        ints.deleteSelected(manip5);
        System.out.print("8-delete all in 15 19 ");
        ints.showAll();

        // Aufgabe 9
        RemoveAndCountAllInIntervalStrategy manip6 = new RemoveAndCountAllInIntervalStrategy(20, 30);
        ints.deleteSelected(manip6);
        System.out.print("9-nb removed : " + manip6.getCount());
        System.out.print(" delete all in 20 30 ");
        ints.showAll();

        // Aufgabe 10
        RemoveSmallerThanPredStrategy manip7 = new RemoveSmallerThanPredStrategy();
        ints.deleteSelected(manip7);
        System.out.print("10- delete smaller then pred ");
        ints.showAll();

        // Aufgabe 11
        ints.add(0);
        OneFollowsZeroStrategy manip8 = new OneFollowsZeroStrategy();
        ints.insertBehindSelected(manip8);
        System.out.print("11- insert 0 behind every 1 ");
        ints.showAll();

        // Aufgabe 12
        SubtotalStrategy manip9 = new SubtotalStrategy();
        ints.insertBehindSelected(manip9);
        System.out.print("12- Subtotal ");
        ints.showAll();

        // Aufgabe 13
        SubtotalOfThree manip10 = new SubtotalOfThree();
        ints.insertBehindSelected(manip10);
        System.out.print("13- Subtotal of three ");
        ints.showAll();

        // Aufgabe 14
        DoublyLinkedList<Integer> ints1 = new DoublyLinkedList<Integer>();

        ints1.add(5);
        ints1.add(-6);
        ints1.add(7);
        ints1.add(20);
        ints1.add(25);
        ints1.add(1);
        ints1.add(-5);
        ints1.add(60);
        ints1.add(110);
        ints1.add(29);
        ints1.add(-5);
        ints1.add(60);
        ints1.add(110);
        System.out.print("14- Insert from List ");
        ints1.showAll();

        InsertFromListStrategy manip11 = new InsertFromListStrategy(ints1);
        ints.insertBehindSelected(manip11);
        System.out.print("result ");
        ints.showAll();

    }
}
