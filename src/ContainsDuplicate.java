
import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
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
