
import java.util.HashSet;

public class LargestNumberAtLeastTwiceofOthers {

    public int dominantIndex(int[] nums) {
        HashSet<Integer> set = new HashSet();
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        for (int key : set) {
            if (key != max && 2 * key > max) {
                return -1;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        LargestNumberAtLeastTwiceofOthers lnatoo = new LargestNumberAtLeastTwiceofOthers();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(lnatoo.dominantIndex(nums));
    }
}
