
import java.util.PriorityQueue;

public class SellDiminishingValuedColoredBalls {

    private int mod = 1000000007;

    public int maxProfit(int[] inventory, int orders) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < inventory.length; i++) {
            maxHeap.add(inventory[i]);
        }
        int ans = 0;
        for (int i = 1; i <= orders; i++) {
            int max = maxHeap.poll();
            ans = (ans % mod + max % mod) % mod;
            maxHeap.add(max - 1);
        }
        return ans;
    }

    public static void main(String args[]) {
        SellDiminishingValuedColoredBalls sdvcb = new SellDiminishingValuedColoredBalls();
        int[] inventory = new int[]{2, 5};
        System.out.println(sdvcb.maxProfit(inventory, 4));
    }
}
