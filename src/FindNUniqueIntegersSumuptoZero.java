
import java.util.Arrays;

public class FindNUniqueIntegersSumuptoZero {

    public int[] sumZero(int n) {
        int[] arr = new int[n];
        if (n % 2 == 0) {
            for (int i = 0, j = 1; i < arr.length; i++, j = j * -1) {
                if (i != 0 && i % 2 == 0) {
                    j++;
                }
                arr[i] = j;
            }
        } else {
            for (int i = 0, j = 1; i < arr.length - 1; i++, j = j * -1) {
                if (i != 0 && i % 2 == 0) {
                    j++;
                }
                arr[i] = j;
            }
            arr[n - 1] = 0;
        }
        return arr;
    }

    public static void main(String args[]) {
        FindNUniqueIntegersSumuptoZero fnuisz = new FindNUniqueIntegersSumuptoZero();
        System.out.println(Arrays.toString(fnuisz.sumZero(4)));
    }
}
