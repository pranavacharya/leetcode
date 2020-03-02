
import java.util.HashMap;

public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) == 2) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int num : map.keySet()) {
            ans = num;
        }
        return ans;
    }

    public static void main(String args[]) {
        SingleNumber2 sn2 = new SingleNumber2();
        int[] input = new int[]{0, 1, 0, 1, 0, 1, 99};
        System.out.println(sn2.singleNumber(input));
    }
}
