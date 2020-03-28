
import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        int max = 0;
        for (int k : map.keySet()) {
            max = max > map.get(k) ? max : map.get(k);
        }
        return max;
    }

    public static void main(String args[]) {
        MajorityElement me = new MajorityElement();
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(me.majorityElement(nums));
    }
}
