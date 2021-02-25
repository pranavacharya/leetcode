
import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }

        Arrays.sort(temp);
        int i = 0;
        int j = nums.length - 1;
        while (i < nums.length && nums[i] == temp[i]) {
            i++;
        }

        while (j >= 0 && nums[j] == temp[j]) {
            j--;
        }

        if (i > j) {
            return 0;
        } else {
            return j - i + 1;
        }
    }

    public static void main(String args[]) {
        ShortestUnsortedContinuousSubarray sucs = new ShortestUnsortedContinuousSubarray();
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(sucs.findUnsortedSubarray(nums));
    }
}
