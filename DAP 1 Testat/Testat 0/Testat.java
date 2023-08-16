
public class Testat {
    public static int[] apply(int[] arr, int x) {
        int nb = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != x) {
                nb++;

            }
        }
        int[] arr1 = new int[nb];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != x) {
                arr1[index] = arr[i];
                index++;
            }
        }

        return arr1;

    }
}
