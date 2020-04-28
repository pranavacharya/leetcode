
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueNumber {

    private Queue<Integer> nums;
    private HashMap<Integer, Integer> map;
    private int fu;

    public FirstUniqueNumber(int[] nums) {
        this.nums = new LinkedList();
        this.fu = -1;
        map = new HashMap();
        for (int num : nums) {
            this.nums.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public int showFirstUnique() {
        while (!this.nums.isEmpty()) {
            int current = this.nums.peek();
            if (this.map.get(current) > 1) {
                this.nums.remove();
            } else {
                System.out.println(current);
                return current;
            }
        }
        System.out.println(-1);
        return -1;
    }

    public void add(int value) {
        if (this.map.containsKey(value)) {
            this.map.put(value, this.map.get(value) + 1);
        } else {
            this.map.put(value, 1);
            this.nums.add(value);
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
