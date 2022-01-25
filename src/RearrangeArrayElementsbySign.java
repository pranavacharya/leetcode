
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RearrangeArrayElementsbySign {

    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> pos = new LinkedList();
        Queue<Integer> neg = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg.add(nums[i]);
            } else {
                pos.add(nums[i]);
            }
        }
        int[] ans = new int[nums.length];

        int index = 0;
        while (!pos.isEmpty()) {
            ans[index++] = pos.poll();
            ans[index++] = neg.poll();
        }

        return ans;
    }

    public static void main(String[] args) {
        RearrangeArrayElementsbySign raes = new RearrangeArrayElementsbySign();
        int[] nums = new int[]{-1, 1};
        System.out.println(Arrays.toString(raes.rearrangeArray(nums)));
    }
}
