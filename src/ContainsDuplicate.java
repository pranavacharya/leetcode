
import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(cd.containsDuplicate(nums));
    }
}
