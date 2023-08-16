public class Methoden {
    public static void main(String[] args) {
        Student s1 = new Student("a", "a", 1);
        Student s2 = new Student("b", "a", 0);

        Student[] arr = { s1, null, s2, null, null, s1, null };
        compress(arr);

    }

    public static void compress(Object[] arr) {

        int positionNextNull = 0;
        int positionNextObject = 0;
        while (positionNextNull < arr.length && positionNextObject < arr.length) {
            if (arr[positionNextNull] != null) {
                positionNextNull++;
            } else {

                while (positionNextObject < arr.length) {
                    if (arr[positionNextObject] == null) {
                        positionNextObject++;

                    } else {
                        Object temp = arr[positionNextObject];
                        arr[positionNextObject] = null;
                        arr[positionNextNull] = temp;
                        positionNextNull++;
                        break;

                    }
                }

            }
        }

    }
}