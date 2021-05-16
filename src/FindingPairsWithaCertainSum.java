
import java.util.HashMap;

public class FindingPairsWithaCertainSum {

    private HashMap<Integer, Integer> map1;
    private HashMap<Integer, Integer> map2;
    private int[] nums1;
    private int[] nums2;

    public FindingPairsWithaCertainSum(int[] nums1, int[] nums2) {
        this.map1 = new HashMap();
        this.map2 = new HashMap();
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int i = 0; i < nums1.length; i++) {
            this.map1.put(this.nums1[i], this.map1.getOrDefault(this.nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            this.map2.put(this.nums2[i], this.map2.getOrDefault(this.nums2[i], 0) + 1);
        }
    }

    public void add(int index, int val) {
        this.map2.put(this.nums2[index], this.map2.get(this.nums2[index]) - 1);
        this.nums2[index] += val;
        this.map2.put(this.nums2[index], this.map2.getOrDefault(this.nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int key1 : this.map1.keySet()) {
            int comp = this.map2.getOrDefault(tot - key1, 0);
            count += this.map1.get(key1) * comp;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 2, 2, 2, 3};
        int[] nums2 = new int[]{1, 4, 5, 2, 5, 4};
        FindingPairsWithaCertainSum findSumPairs = new FindingPairsWithaCertainSum(nums1, nums2);
        System.out.println(findSumPairs.count(7));  // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
        findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
        System.out.println(findSumPairs.count(8));  // return 2; pairs (5,2), (5,4) make 3 + 5
        System.out.println(findSumPairs.count(4));  // return 1; pair (5,0) makes 3 + 1
        findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
        System.out.println(findSumPairs.count(7));  // return 11; pairs (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) make 2 + 5 and pairs (5,3), (5,5) make 3 + 4
    }
}
