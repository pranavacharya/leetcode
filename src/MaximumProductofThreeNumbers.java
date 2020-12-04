
import java.util.Arrays;

public class MaximumProductofThreeNumbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int last = 1;
        for (int i = nums.length - 1; i >= nums.length - 3; i--) {
            last = last * nums[i];
        }
        int first = 1;
        for (int i = 0; i < 2; i++) {
            first = first * nums[i];
        }
        first = first * nums[nums.length - 1];
        return Math.max(first, last);
    }

    public static void main(String args[]) {
        MaximumProductofThreeNumbers mptn = new MaximumProductofThreeNumbers();
        int[] nums = new int[]{-1, -2, -3};
        System.out.println(mptn.maximumProduct(nums));
    }
}
