
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int[] data = new int[nums.length + 1];
        for (int i : nums) {
            data[i] = 1;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        MissingNumber mn = new MissingNumber();
        int[] nums = new int[]{3, 0, 1};
        System.out.println(mn.missingNumber(nums));
    }
}
