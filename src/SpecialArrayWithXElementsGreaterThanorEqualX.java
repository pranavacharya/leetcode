
import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanorEqualX {

    public int specialArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    if (nums.length - j == i) {
                        return i;
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        SpecialArrayWithXElementsGreaterThanorEqualX sawxgtx
                = new SpecialArrayWithXElementsGreaterThanorEqualX();
        int[] nums = new int[]{0, 4, 3, 0, 4};
        System.out.println(sawxgtx.specialArray(nums));
    }
}
