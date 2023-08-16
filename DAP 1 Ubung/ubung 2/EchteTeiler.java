public class EchteTeiler {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 3, 3, 3, 2, 2, 5, 5, 5 };
        primeFactorisation(50);
        Aufgabe_2_4.primeFactorization(-2);
        System.out.println();
        System.out.println();

    }

    public static int greatestProperDivisor(int n) {
        int divisor = 1;
        /* this was missing when n is negative no for loop */
        if (n < 0) {
            n = -n;
        }
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
        /*
         * for (int i = 0; i < exam1.length; i++) {
         * for (int j = 0; j < exam2.length; j++) {
         * if (exam1[i] <= exam2[j]) {
         * return false;
         * }
         * 
         * }
         * }
         * return true;
         */
        // find minimum
        int minimum = exam1[0];
        for (int i = 1; i < exam1.length; i++) {
            if (exam1[i] < minimum) {
                minimum = exam1[i];

            }

        }
        for (int i = 0; i < exam2.length; i++) {
            if (minimum <= exam2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void primeFactorisation(int x) {
        System.out.print(x + " = ");
        if (x < 0) {
            x = -x;
        }
        if (x <= 1) {
            System.out.println(x);
        }

        while (x >= 2) {
            int i = 2;

            while (x % i != 0) {
                i++;
            }
            x = x / i;
            System.out.print(i);
            if (x > 1) {
                System.out.print(" * ");

            }

        }

    }

    public static boolean isSquare(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                return false;
            }

        }

        return true;

    }

    public static void scalMuLt(int[][] matrix, int k) {
        if (isSquare(matrix)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] *= k;
                }
            }
        }
    }

    public static int[] extractDiagnal(int[][] matrix) {
        if (isSquare(matrix)) {
            int m = matrix.length;
            int[] diagonal = new int[m];
            for (int i = 0; i < m; i++) {
                diagonal[i] = matrix[i][i];

            }
            return diagonal;
        }
        return new int[0];

    }

}
