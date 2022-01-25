
import java.util.Arrays;

public class CountElementsWithStrictlySmallerandGreaterElements {

    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        int j = nums.length - 1;
        while (j - 1 > 0 && nums[j - 1] == nums[j] && j != i) {
            j--;
        }
        if (i == j) {
            return 0;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        CountElementsWithStrictlySmallerandGreaterElements cewssge = new CountElementsWithStrictlySmallerandGreaterElements();
        int[] nums = new int[]{11, 7, 2, 15};
        System.out.println(cewssge.countElements(nums));
    }
}
