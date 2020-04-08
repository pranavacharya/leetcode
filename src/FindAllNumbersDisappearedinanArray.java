
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
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
