
import java.util.HashMap;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (k >= i - map.get(nums[i])) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ContainsDuplicate2 cd2 = new ContainsDuplicate2();
        int[] nums = new int[]{1, 0, 1, 1};
        System.out.println(cd2.containsNearbyDuplicate(nums, 1));
    }
}
