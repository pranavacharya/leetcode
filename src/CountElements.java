
import java.util.Arrays;
import java.util.HashSet;

public class CountElements {

    public int countElements(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i] + 1)) {
                count++;
            }
            set.add(arr[i]);
        }
        return count;
    }

    public static void main(String args[]) {
        CountElements ce = new CountElements();
        int[] arr = new int[]{1, 3, 2, 3, 5, 0};
        System.out.println(ce.countElements(arr));
    }
}
