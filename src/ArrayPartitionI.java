
import java.util.Arrays;

public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String args[]) {
        ArrayPartitionI ap = new ArrayPartitionI();
        int[] nums = new int[]{1, 4, 3, 2};
        System.out.println(ap.arrayPairSum(nums));
    }
}
