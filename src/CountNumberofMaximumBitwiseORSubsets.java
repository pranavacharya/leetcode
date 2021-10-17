
public class CountNumberofMaximumBitwiseORSubsets {

    private int max;
    private int max_count;

    public int countMaxOrSubsets(int[] nums) {
        this.max = -1;
        this.max_count = 0;
        backtracking(nums, 0, 0);
        return max_count;
    }

    private void backtracking(int[] nums, int index, int or) {

        if (index == nums.length) {
            if (or > this.max) {
                this.max = or;
                this.max_count = 1;
            } else if (or == this.max) {
                this.max_count++;
            }
            return;
        }

        int localOr = or;

        // consider
        localOr = localOr | nums[index];
        backtracking(nums, index + 1, localOr);

        // dont consider
        backtracking(nums, index + 1, or);

    }

    public static void main(String[] args) {
        CountNumberofMaximumBitwiseORSubsets cnmbos = new CountNumberofMaximumBitwiseORSubsets();
        int[] nums = new int[]{2, 2, 2};
        System.out.println(cnmbos.countMaxOrSubsets(nums));
    }
}
