
public class NondecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int last = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > last) {
                count++;
            } else {
                last = nums[i];
            }
        }
        if (count < 2) {
            return true;
        }
        last = nums[0];
        count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (last > nums[i]) {
                count++;
            } else {
                last = nums[i];
            }
        }
        return count < 2;
    }

    public static void main(String[] args) {
        NondecreasingArray nda = new NondecreasingArray();
        int[] nums = new int[]{3, 4, 2, 3};
        System.out.println(nda.checkPossibility(nums));
    }
}
