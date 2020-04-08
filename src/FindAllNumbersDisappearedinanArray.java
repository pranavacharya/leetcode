
import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]);
            nums[temp - 1] = Math.abs(nums[temp - 1]) * -1;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        FindAllNumbersDisappearedinanArray fanda = new FindAllNumbersDisappearedinanArray();
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(fanda.findDisappearedNumbers(nums));
    }
}
