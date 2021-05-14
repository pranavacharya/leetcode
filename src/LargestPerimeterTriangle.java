
import java.util.Arrays;

public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (nums[k] + nums[j] > nums[i]) {
                        return nums[k] + nums[j] + nums[i];
                    }
                }
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
