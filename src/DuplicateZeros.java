
import java.util.Arrays;

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                continue;
            } else {
                for (int j = arr.length - 1; j > i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                if (i != arr.length - 1) {
                    arr[i + 1] = 0;
                }
                i++;
            }
        }
    }

    public static void main(String args[]) {
        DuplicateZeros dz = new DuplicateZeros();
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        dz.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
