
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList();
        int index = Arrays.binarySearch(arr, x);
        if (index < 0) {
            index = (index + 1) * -1;
        }
        int i = index - 1;
        int j = index;
        while (k > 0) {

            if (i >= 0 && j < arr.length && Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                ans.add(0, arr[i]);
                i--;
            } else if (j < arr.length) {
                ans.add(arr[j]);
                j++;
            } else {
                ans.add(0, arr[i]);
                i--;
            }
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindKClosestElements fkce = new FindKClosestElements();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(fkce.findClosestElements(arr, 4, 3));
    }
}
