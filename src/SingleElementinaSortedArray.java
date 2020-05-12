
public class SingleElementinaSortedArray {

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        for (int i = 1; i < nums.length - 2; i++) {
            if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                return nums[i];
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        return -1;
    }

    public static void main(String args[]) {
        SingleElementinaSortedArray seisa = new SingleElementinaSortedArray();
        int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(seisa.singleNonDuplicate(nums));
    }
}
