
import java.util.HashMap;

public class NumberofGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int count = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                count += map.get(num);
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return count;
    }

    public static void main(String args[]) {
        NumberofGoodPairs ngp = new NumberofGoodPairs();
        int[] nums = new int[]{1, 2, 3, 1, 1, 3};
        System.out.println(ngp.numIdenticalPairs(nums));
    }
}
