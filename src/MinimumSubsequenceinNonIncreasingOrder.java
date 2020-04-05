
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceinNonIncreasingOrder {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int i;
        for (i = nums.length - 1; i > 0; i--) {
            if (sumOfElements(i, nums.length - 1, nums) > sumOfElements(0, i - 1, nums)) {
                break;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = nums.length - 1; j >= i; j--) {
            list.add(nums[j]);
        }
        return list;
    }

    public int sumOfElements(int i, int j, int[] nums) {
        int sum = 0;
        while (i <= j) {
            sum += nums[i];
            i++;
        }
        return sum;
    }

    public static void main(String args[]) {
        MinimumSubsequenceinNonIncreasingOrder msino = new MinimumSubsequenceinNonIncreasingOrder();
        int[] nums = new int[]{6};
        System.out.println(msino.minSubsequence(nums));
    }
}
