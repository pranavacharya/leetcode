
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllLonelyNumbersintheArray {

    public List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList();

        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!(map.containsKey(nums[i] - 1) || map.containsKey(nums[i] + 1)) && map.get(nums[i]) == 1) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindAllLonelyNumbersintheArray flna = new FindAllLonelyNumbersintheArray();
        int[] nums = new int[]{10, 6, 5, 8};
        System.out.println(flna.findLonely(nums));
    }
}
