public class WerteZahlen {

    public static int interval(int a, int b) {
        int sum = 0;
        if (a > b) {
            for (int i = b; i <= a; i++) {
                sum += i;

            }

        } else {
            for (int i = a; i <= b; i++) {
                sum += i;
            }
        }

        return sum;
    }

    public static int digitSum(int x) {
        int sum = 0;
        x = Math.abs(x);
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }

    public static String digitToString(int n) {
        if (n < 0 || n > 9) {
            return "";
        }
        String[] numbers = { "null", "eins", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun" };
        return numbers[n];

    }

    public static String intToString(int z) {
        String result = "";
        String minus = "";
        if (z < 0) {
            minus = "minus-";
            z = -z;
        }

        while (z > 9) {
            int digit = z % 10;
            result = "-" + digitToString(digit) + result;
            z = z / 10;

        }
        return minus + digitToString(z % 10) + result;
    }

    public static void main(String[] args) {

        int[] arr = { 1 };
        String count = intToString(0);

        System.out.println(count);

    }

    public static int countNegatives(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                count++;
            }

        }
        return count;
    }

    int sumUpNegatives(int[] arr) {
        int summe = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                summe += arr[i];
            }

        }
        return summe;

    }

    public static int maximum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

        }
        return max;

    }

    public static int countMaximum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int max = arr[0];
        int countMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                countMax++;
            }
            if (arr[i] > max) {
                max = arr[i];
                countMax = 1;
            }

        }
        return countMax;

    }

    public static boolean isSorted(int[] arr) {
        int last = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < last) {
                return false;
            } else {
                last = arr[i];
            }

        }
        return true;

    }

    public static boolean checkArray(int[] arr) {
        int n = arr.length;
        System.out.println(n);

        for (int i = 0; i < (n / 2); i++) {
            System.out.println(i);
            if (arr[i] != arr[n - i - 1]) {
                return false;

            }
        }
        return true;
    }

    public static int[] increaseArray(int[] arr, int z) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += z;
        }
        return arr;

    }

    public static int[] doubleIfContainsPositive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                for (int j = 0; j < arr.length; j++) {
                    arr[j] *= 2;
                }
                return arr;
            }

        }
        return arr;
    }

    public static String toString(int[] arr) {
        String feld = "";
        int i = 0;

        while (i < arr.length)

        {
            feld += arr[i] + ", ";
            i++;

        }
        return feld;

    }

    public static int[] copyStartingValues(int[] arr) {
        int n = arr.length;
        if (n <= 3) {
            return arr;

        }
        int[] copyarr = new int[3];
        copyarr[0] = arr[0];
        copyarr[1] = arr[1];
        copyarr[2] = arr[2];
        return copyarr;

    }

    public static int[] selectNegatives(int[] arr) {
        int n = countNegatives(arr);
        int count = 0;
        int negatives[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0) {
                negatives[count] = arr[i];
                count++;

            }
        }
        return negatives;
    }

    public static int[] copyAndInvert(int[] arr) {
        int n = arr.length;
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = arr[n - i - 1];

        }
        return copy;
    }

    public static int[] addArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        if (arr2.length != n) {
            return new int[0];

        }
        int[] feld = new int[n];
        for (int i = 0; i < n; i++) {
            feld[i] = arr1[i] + arr2[i];

        }
        return feld;
    }

    public static int countSequences(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != 0) {
                if (arr[i + 1] == 0) {
                    count++;
                }

            }
        }
        if (arr[arr.length - 1] != 0) {
            count++;
        }
        return count;
    }

    public static boolean twoTimes(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int number = arr[i];
            for (int j = 0; j < n; j++) {
                if (number == arr[j]) {
                    count++;
                }
            }
            if (count != 2) {
                return false;
            }

        }
        return true;
    }

}