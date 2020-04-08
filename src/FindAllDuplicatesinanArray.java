
import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return ans;
    }

    public static void main(String args[]) {
        FindAllDuplicatesinanArray fdia = new FindAllDuplicatesinanArray();
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(fdia.findDuplicates(nums));
    }
}
