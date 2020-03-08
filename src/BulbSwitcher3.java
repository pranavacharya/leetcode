
import java.util.HashSet;
import java.util.PriorityQueue;

public class BulbSwitcher3 {

    public int numTimesAllBlue(int[] light) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> (b - a));
        for (int k = 0; k < light.length; k++) {
            set.add(light[k]);
            minheap.add(light[k]);
            maxheap.add(light[k]);
            if (set.size() == k + 1 && minheap.peek() == 1 && maxheap.peek() == k + 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        BulbSwitcher3 bs3 = new BulbSwitcher3();
        int[] light = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(bs3.numTimesAllBlue(light));
    }
}
