
public class NumberofSubarrayswithBoundedMaximum {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = -1;
        int end = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                start = i;
            }
            if (nums[i] >= left) {
                end = i;
            }
            count += end - start;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberofSubarrayswithBoundedMaximum nsabm = new NumberofSubarrayswithBoundedMaximum();
        int[] nums = new int[]{2, 1, 4, 3};
        System.out.println(nsabm.numSubarrayBoundedMax(nums, 2, 3));
    }
}
