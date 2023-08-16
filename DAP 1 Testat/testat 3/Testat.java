public class Testat {
    public static int apply(int[] arr, int i) {

        if (i < 0 || i >= arr.length) {
            return 0;

        } else {
            int[] a={1,null};
            if (i == 0) {
                if (arr[0] % 2 == 1 && arr[0] > 10) {
                    return 1;
                }
                return 0;
            } else {
                if (arr[i] % 2 == 1 && arr[i] > 10) {
                    return 1 + apply(arr, i - 1);
                }
                return apply(arr, i - 1);

            }

        }

    }
}