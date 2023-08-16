public class QuickSort {
    private int[] numbers;

    public QuickSort(int[] t) {
        numbers = t;
    }

    public static void main(String[] args) {
        int[] t1 = { 7, 15, 3, 17, 19, 10, 5, 6, 11 };
        int[] t2 = { 3, 5, 6, 7, 10, 11, 15, 17, 19 };
        int[] t3 = { 19, 17, 15, 11, 10, 7, 6, 5, 3 };
        QuickSort a = new QuickSort(t1);
        QuickSort b = new QuickSort(t2);
        QuickSort c = new QuickSort(t3);
        c.getClass();
        b.quickSort();
        a.quickSort();

    }

    private void groupByNumber(int leftBound, int rightBound) {
        int leftBigPart = leftBound;
        if (leftBound < rightBound) {
            for (int i = leftBound; i <= rightBound; i++) {

                if (numbers[i] < numbers[rightBound]) {
                    swap(leftBigPart, i);
                    leftBigPart++;
                }
            }
            System.out.println("pivot : " + numbers[rightBound]);
            swap(leftBigPart, rightBound);
            groupByNumber(leftBound, leftBigPart - 1);
            groupByNumber(leftBigPart + 1, rightBound);

        }
    }

    private void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;

    }

    public void quickSort() {
        groupByNumber(0, numbers.length - 1);

    }

}
