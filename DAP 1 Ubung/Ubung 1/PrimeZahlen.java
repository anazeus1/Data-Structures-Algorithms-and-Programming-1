public class PrimeZahlen {
    public static void main(String args[]) {
        int n = 13;
        boolean[] arr = InitNumbers(n);
        inspectNumbers(arr);

    }

    public static boolean[] InitNumbers(int n) {
        boolean[] numbers = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            numbers[i] = true;
        }
        return numbers;

    }

    public static void inspectNumbers(boolean[] arr) {
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == true) {
                removeMultiples(arr, i);
            }
        }
    }

    public static void removeMultiples(boolean[] arr, int n) {
        for (int i = n + 1; i < arr.length; i++) {
            if (arr[i] == true & i % n == 0) {
                arr[i] = false;

            }
        }
    }

}