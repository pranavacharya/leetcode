
import java.util.Arrays;

public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int[] sufix = new int[nums.length + 1];
        sufix[nums.length] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            sufix[i] = sufix[i + 1] * nums[i];
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = prefix[i] * sufix[i + 1];
        }
        return ans;
    }

    public static void main(String args[]) {
        ProductofArrayExceptSelf paes = new ProductofArrayExceptSelf();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(paes.productExceptSelf(nums)));
    }
}
