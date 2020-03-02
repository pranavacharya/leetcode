
import java.util.HashSet;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        for (Object object : set) {
            res = (int) object;
        }
        return res;
    }

    public static void main(String args[]) {
        SingleNumber sn = new SingleNumber();
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(sn.singleNumber(nums));
    }
}
