import java.util.ArrayList;
import java.util.Random;

public class dataInput {

    private static int n = 9;           // Size of array

    public static int[] generateRandomArray() {

        ArrayList<Integer> list = new ArrayList<Integer>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
