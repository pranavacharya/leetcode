
import java.util.Arrays;
import java.util.PriorityQueue;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        String[] ans = new String[nums.length];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (nums[b] - nums[a]));
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(i);
        }
        int pos = 1;
        while (!maxHeap.isEmpty()) {
            int val = maxHeap.poll();
            if (pos == 1) {
                ans[val] = "Gold Medal";
            } else if (pos == 2) {
                ans[val] = "Silver Medal";
            } else if (pos == 3) {
                ans[val] = "Bronze Medal";
            } else {
                ans[val] = Integer.toString(pos);
            }
            pos++;
        }
        return ans;
    }

    public static void main(String args[]) {
        RelativeRanks rr = new RelativeRanks();
        int[] nums = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(rr.findRelativeRanks(nums)));
    }
}
