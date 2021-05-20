
import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    private HashMap<Integer, Integer> map = new HashMap();

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] + 1)) {
                union(nums[i], nums[i] + 1);
            }
        }
        int max = 0;
        for (int key : this.map.keySet()) {
            int parent = findParent(key);
            max = Math.max(max, key - parent);
        }
        return max + 1;
    }

    private void union(int x, int y) {
        int x1 = findParent(x);
        int y1 = findParent(y);
        this.map.put(y1, x1);
    }

    private int findParent(int key) {
        int child = key;
        while (this.map.containsKey(key) && this.map.get(key) != key) {
            key = this.map.get(key);
        }
        this.map.put(child, key);
        return this.map.get(child);
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(nums));
    }
}
