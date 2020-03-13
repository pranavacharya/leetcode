
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < stones.length; i++) {
            maxheap.add(stones[i]);
        }

        while (!maxheap.isEmpty()) {
            int weight = maxheap.remove();
            if (maxheap.isEmpty()) {
                return weight;
            } else {
                int weight2 = maxheap.remove();
                if (weight - weight2 != 0) {
                    maxheap.add(weight - weight2);
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        LastStoneWeight lsw = new LastStoneWeight();
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lsw.lastStoneWeight(stones));
    }
}
