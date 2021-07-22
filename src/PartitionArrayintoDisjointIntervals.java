
public class PartitionArrayintoDisjointIntervals {

    public int partitionDisjoint(int[] nums) {
        int[] suffix = new int[nums.length + 1];
        int min = Integer.MAX_VALUE;
        for (int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = Math.min(min, nums[i]);
            min = suffix[i];
        }
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max <= suffix[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PartitionArrayintoDisjointIntervals paidi = new PartitionArrayintoDisjointIntervals();
        int[] nums = new int[]{1, 1, 1, 0, 6, 12};
        System.out.println(paidi.partitionDisjoint(nums));
    }
}
