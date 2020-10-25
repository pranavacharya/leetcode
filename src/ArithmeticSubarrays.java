
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList();
        for (int i = 0; i < l.length; i++) {
            int left = l[i];
            int right = r[i];

            int[] arr = new int[right - left + 1];
            int index = 0;
            for (int j = left; j <= right; j++) {
                arr[index++] = nums[j];
            }
            Arrays.sort(arr);
            int diff = arr[1] - arr[0];
            boolean flag = false;
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[j + 1] - arr[j] != diff) {
                    ans.add(false);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans.add(true);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        ArithmeticSubarrays as = new ArithmeticSubarrays();
        int[] nums = new int[]{4, 6, 5, 9, 3, 7};
        int[] l = new int[]{0, 0, 2};
        int[] r = new int[]{2, 3, 5};
        System.out.println(as.checkArithmeticSubarrays(nums, l, r));
    }
}
