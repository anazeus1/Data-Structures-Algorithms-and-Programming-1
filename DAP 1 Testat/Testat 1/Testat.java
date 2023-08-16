public class Testat {
    public static int[] apply(int[] arr, int x) {

        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = arr[i] + x;
            }
        }
        return newArr;

    }
}