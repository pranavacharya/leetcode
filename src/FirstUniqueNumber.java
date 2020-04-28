
import java.util.ArrayList;
import java.util.HashMap;

public class FirstUniqueNumber {

    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> map;
    private int fu;

    public FirstUniqueNumber(int[] nums) {
        this.nums = new ArrayList();
        this.fu = -1;
        map = new HashMap();
        for (int num : nums) {
            this.nums.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = this.nums.size() - 1; i >= 0; i--) {
            if (map.get(this.nums.get(i)) == 1) {
                this.fu = this.nums.get(i);
            }
        }
    }

    public int showFirstUnique() {
        System.out.println(this.fu);
        return this.fu;
    }

    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        this.nums.add(value);
        this.fu = -1;
        for (int i = this.nums.size() - 1; i >= 0; i--) {
            if (map.get(this.nums.get(i)) == 1) {
                this.fu = this.nums.get(i);
            }
        }
    }

    public static void main(String args[]) {
        FirstUniqueNumber firstUnique = new FirstUniqueNumber(new int[]{7, 7, 7, 7, 7, 7});
        firstUnique.showFirstUnique(); // return -1
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        firstUnique.showFirstUnique(); // return 17
    }
}
