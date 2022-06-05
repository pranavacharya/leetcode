
import java.util.Arrays;
import java.util.HashMap;

public class ReplaceElementsinanArray {

    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap();
        HashMap<Integer, Integer> reverse = new HashMap();

        for (int i = 0; i < operations.length; i++) {
            int first = operations[i][0];
            int second = operations[i][1];

            if (reverse.containsKey(first)) {
                int last = reverse.get(first);
                map.put(last, second);
                reverse.remove(first);
                reverse.put(second, last);
            } else {
                map.put(first, second);
                reverse.put(second, first);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                nums[i] = map.get(nums[i]);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        ReplaceElementsinanArray reia = new ReplaceElementsinanArray();
        int[] nums = new int[]{1, 2};
        int[][] operations = new int[][]{{1, 3}, {2, 1}, {3, 2}};
        System.out.println(Arrays.toString(reia.arrayChange(nums, operations)));
    }
}
