public class EchteTeiler {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 3, 3, 3, 2, 2, 5, 5, 5 };
        int[][] arr1 = { { 1, 2, 2 }, { 1, 2, 3 }, { 4, 5, 6 } };
        int nbPairs = countPairs(arr);

        System.out.println(nbPairs);

    }

    public static int greatestProperDivisor(int n) {
        int divisor = 1;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                divisor = i;
            }
        }

        return divisor;
    }

    public static int countPairs(int[] arr) {
        int nbPairs = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                nbPairs++;
                i++;

            }
        }
        /*
         * while (i < arr.length - 1) {
         * if (arr[i] == arr[i + 1]) {
         * nbPairs++;
         * i += 2;
         * } else {
         * i++;
         * }
         * }
         */
        return nbPairs;

    }

    public static boolean writtenBoth(int[] exam1, int[] exam2) {
        for (int i = 0; i < exam1.length; i++) {
            for (int j = 0; j < exam2.length; j++) {
                if (exam1[i] == exam2[j]) {
                    return true;
                }

            }
        }
        return false;

    }

    public static boolean notWrittenBoth(int[] exam1, int[] exam2) {
        for (int i = 0; i < exam1.length; i++) {
            for (int j = 0; j < exam2.length; j++) {
                if (exam1[i] == exam2[j]) {
                    return false;
                }

            }
        }
        return true;
    }

    public static int countWrittenBoth(int[] exam1, int[] exam2) {
        int count = 0;

        for (int i = 0; i < exam1.length; i++) {
            for (int j = 0; j < exam2.length; j++) {
                if (exam1[i] == exam2[j]) {
                    count++;
                }

            }
        }
        return count;
    }

    public static boolean biggerThen(int[] exam1, int[] exam2) {
        for (int i = 0; i < exam1.length; i++) {
            for (int j = 0; j < exam2.length; j++) {
                if (exam1[i] <= exam2[j]) {
                    return false;
                }

            }
        }
        return true;
    }

    public static void primeFactorisation(int x) {
        System.out.print(x + " = ");
        while (x != 1) {
            int i = 2;

            while (x % i != 0) {
                i++;
            }
            x = x / i;

            System.out.print(" * " + i);

        }

    }

    public static boolean isSquare(int[][] matrix) {
        if (matrix.length == matrix[0].length) {
            return true;
        }
        return false;

    }

    public static void scalMuLt(int[][] matrix, int k) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; i < matrix[i].length; j++) {
                matrix[i][j] *= k;
            }
        }
    }

    public static int[] extractDiagnal(int[][] matrix) {
        int m = matrix.length;
        int[] diagonal = new int[m];
        for (int i = 0; i < m; i++) {
            diagonal[i] = matrix[i][i];

        }
        return diagonal;

    }

}
