
public class MinimumSwapstoGroupAll1sTogetherII {

    public int minSwaps(int[] nums) {
        int window = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                window++;
            }
        }
        int swaps = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int zeros = 0;
        while (j < 2 * n) {
            if (nums[j % n] == 0) {
                zeros++;
            }
            j++;
            if (j - i > window) {
                if (nums[i % n] == 0) {
                    zeros--;
                }
                i++;
            }
            if (j - i == window) {
                swaps = Math.min(swaps, zeros);
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        MinimumSwapstoGroupAll1sTogetherII msg = new MinimumSwapstoGroupAll1sTogetherII();
        int[] nums = new int[]{0, 1, 0, 1, 1, 0, 0};
//        int[] nums = new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0};
        System.out.println(msg.minSwaps(nums));
    }
}
