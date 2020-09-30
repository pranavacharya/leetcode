
import java.util.HashSet;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                set.add(nums[i]);
            }
        }
        int ans = 1;
        while (set.contains(ans)) {
            ans++;
        }
        return ans;
    }

    public static void main(String args[]) {
        FirstMissingPositive pmp = new FirstMissingPositive();
        int[] nums = new int[]{3, 4, -1, 1};
        System.out.println(pmp.firstMissingPositive(nums));
    }
}
