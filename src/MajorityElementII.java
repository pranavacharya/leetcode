
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > (nums.length / 3)) {
                result.add(key);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        MajorityElementII me = new MajorityElementII();
        int[] nums = new int[]{1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(me.majorityElement(nums));
    }
}
