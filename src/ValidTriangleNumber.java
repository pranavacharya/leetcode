
import java.util.Arrays;

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += Math.max(0, (k - j - 1));
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
