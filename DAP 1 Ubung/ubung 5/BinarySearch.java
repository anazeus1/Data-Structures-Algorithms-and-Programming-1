import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {

    }

    public static boolean binarySearchRecursive(int[] numbers, int number, int leftBound, int rightBound) {
        if (rightBound - leftBound >= 0) {
            int middle = (rightBound - leftBound) / 2 + leftBound;
            if (numbers[middle] > number) {

                return binarySearchRecursive(numbers, number, leftBound, middle - 1);
            } else if (numbers[middle] < number) {

                return binarySearchRecursive(numbers, number, middle + 1, rightBound);
            }
            return true;

        }
        return false;

    }
}
