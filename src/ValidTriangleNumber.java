
import java.util.Arrays;

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ValidTriangleNumber vtn = new ValidTriangleNumber();
        int[] nums = new int[]{2, 2, 3, 4};
        System.out.println(vtn.triangleNumber(nums));
    }
}
