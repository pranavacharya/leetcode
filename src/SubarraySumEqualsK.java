
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (prefix[j + 1] - prefix[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        SubarraySumEqualsK sase = new SubarraySumEqualsK();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(sase.subarraySum(nums, 3));
    }
}
