
import java.util.Arrays;

public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle lpt = new LargestPerimeterTriangle();
        int[] nums = new int[]{2, 1, 2};
        System.out.println(lpt.largestPerimeter(nums));
    }
}
