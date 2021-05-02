
public class MinimumDistancetotheTargetElement {

    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(min, Math.abs(start - i));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumDistancetotheTargetElement mdts = new MinimumDistancetotheTargetElement();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(mdts.getMinDistance(nums, 5, 3));
    }
}
