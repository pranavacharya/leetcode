
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (isEqualOnesAndZeros(nums, i, j)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public boolean isEqualOnesAndZeros(int[] nums, int i, int j) {
        int ones = 0;
        for (int start = i; start <= j; start++) {
            if (nums[start] == 1) {
                ones++;
            }
        }
        return (j - i + 1) == (ones * 2);
    }

    public static void main(String args[]) {
        ContiguousArray ca = new ContiguousArray();
        int[] nums = new int[]{0, 0, 1, 0, 0, 0, 1, 1};
//        int[] nums = new int[]{0, 1};
        System.out.println(ca.findMaxLength(nums));
    }
}
