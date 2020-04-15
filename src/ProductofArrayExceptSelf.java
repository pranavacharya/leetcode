
import java.util.Arrays;

public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int prod = 1;
        for (int i : nums) {
            prod *= i;
        }
        for (int i = 0; i < ans.length; i++) {
            if (nums[i] != 0) {
                ans[i] = prod / nums[i];
            } else {
                int temp = 1;
                for (int j = 0; j < nums.length; j++) {
                    if (j != i) {
                        temp *= nums[j];
                    }
                }
                ans[i] = temp;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        ProductofArrayExceptSelf paes = new ProductofArrayExceptSelf();
        int[] nums = new int[]{0, 0};
        System.out.println(Arrays.toString(paes.productExceptSelf(nums)));
    }
}
