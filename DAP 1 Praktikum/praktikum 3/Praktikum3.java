import javax.management.RuntimeErrorException;

public class Praktikum3 {
    public static void main(String[] main) {
        int[] arr = { -20, -2, 5, 25, 16, 25, 36, 0, 5, 10 };
        int[] arr3 = { 0 };
        char[] arr1 = { 'a', 'b', 'a' };
        char[] arr2 = { 'a', 'c', 'b', 'a' };

        System.out.println(Queersumme(0));
        System.out.println(potenz(5, -2));
        System.out.println(sumUpNegatives(arr, 3));
        System.out.println(countPositives(arr, 7));
        System.out.println(countPositivesLimited(arr, 1, 5));
        System.out.println(maximum(arr, 9));
        System.out.println(isSorted(arr, 5));
        System.out.println(contains(arr, 7, 0));
        System.out.println(contentCheck(arr1, arr2, 1));
        System.out.println(palindromCheck(arr1, 2));
        System.out.println(getIndex(arr, 9, 5));
        System.out.println(toString(arr, 0));

    }

    public static int Queersumme(int n) {
        n = Math.abs(n);
        if (n < 10) {
            return n;
        }
        return Queersumme(n / 10) + n % 10;

    }

    public static int potenz(int n, int power) {
        if (power < 0 || n == 0) {
            return 0;
        } else if (power == 0) {
            return 1;
        }
        return n * potenz(n, power - 1);

    }

    public static int sumUpNegatives(int[] arr, int n) {
        if (n < 0 || n >= arr.length) {
            return 0;
        } else if (n == 0) {
            if (arr[n] < 0) {
                return arr[n];
            }
            return 0;

        } else if (arr[n] < 0) {
            return sumUpNegatives(arr, n - 1) + arr[n];
        }
        return sumUpNegatives(arr, n - 1);

    }

    public static int countPositives(int[] arr, int n) {
        if (n < 0 || n >= arr.length) {
            return 0;
        } else {
            if (n == 0) {
                if (arr[n] >= 0) {
                    return 1;
                }
                return 0;
            }
            if (arr[n] >= 0) {
                return 1 + countPositives(arr, n - 1);

            }
            return countPositives(arr, n - 1);
        }
    }

    public static int countPositivesLimited(int[] arr, int d, int t) {
        if (d > t || t < 0 || d < 0 || t >= arr.length) {

            return 0;
        } else {
            if (t == d) {
                if (arr[t] > 0) {
                    return 1;
                }
                return 0;
            } else {
                if (arr[d] > 0) {
                    return 1 + countPositivesLimited(arr, d + 1, t);

                }
                return countPositivesLimited(arr, d + 1, t);
            }
        }
    }

    public static int maximum(int[] arr, int i) {
        if (i < 0 || i >= arr.length) {
            throw new RuntimeException();
        } else {
            if (i == 0) {
                return arr[0];
            }
            int max = maximum(arr, i - 1);
            if (max > arr[i]) {
                return max;
            }
            return arr[i];
        }

    }

    public static boolean isSorted(int[] arr, int i) {
        if (i >= arr.length || i < 0) {
            throw new RuntimeException();

        } else {
            if (i == 0) {
                return true;
            } else if (arr[i] < arr[i - 1]) {
                return false;
            }
            return isSorted(arr, i - 1);
        }
    }

    public static boolean contains(int[] arr, int i, int x) {
        if (i < 0 || i >= arr.length) {
            throw new RuntimeException();
        } else {
            if (i == 0) {
                if (arr[i] == x) {
                    return true;
                }
                return false;

            }
            if (arr[i] == x) {
                return true;
            }
            return contains(arr, i - 1, x);
        }
    }

    public static boolean contentCheck(char[] arr1, char[] arr2, int i) {
        if (i < 0 || i >= arr1.length || i >= arr2.length) {
            throw new RuntimeException();

        } else {

            if (i == 0) {
                if (arr1[i] == arr2[i]) {
                    return true;
                }
                return false;
            }
            if (arr1[i] == arr2[i]) {
                return contentCheck(arr1, arr2, i - 1);
            }
            return false;
        }
    }

    public static boolean palindromCheck(char[] arr, int i) {
        if (i < 0 || i >= arr.length) {
            return false;

        } else {
            int j = arr.length - i - 1;
            if (i < j) {
                return true;
            }

            if (arr[i] == arr[j]) {
                return palindromCheck(arr, i - 1);
            }
            return false;
        }
    }

    public static int getIndex(int[] arr, int i, int x) {
        if (i < 0 || i >= arr.length) {
            return -1;
        } else {
            int lower = getIndex(arr, i - 1, x);
            if (lower != -1 || arr[i] != x) {
                return lower;
            } else {
                return i;
            }

        }
    }

    public static String toString(int[] arr, int i) {
        if (i >= arr.length - 1) {
            return String.valueOf(arr[i]);
        }
        return String.valueOf(arr[i]).concat(toString(arr, i + 1));
    }

}