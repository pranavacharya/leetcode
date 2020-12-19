
import java.util.PriorityQueue;

public class StoneGameVI {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int aScore = 0;
        int bScore = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> aliceValues[b] + bobValues[b]
                - aliceValues[a] - bobValues[a]);
        for (int i = 0; i < aliceValues.length; i++) {
            maxHeap.add(i);
        }
        int turn = 0;
        while (!maxHeap.isEmpty()) {
            int index = maxHeap.poll();
            if (turn % 2 == 0) {
                aScore += aliceValues[index];
            } else {
                bScore += bobValues[index];
            }
            turn++;
        }
        if (aScore == bScore) {
            return 0;
        }
        return aScore > bScore ? 1 : -1;
    }

    public static void main(String args[]) {
        StoneGameVI sg = new StoneGameVI();
        int[] aliceValues = new int[]{1, 2};
        int[] bobValues = new int[]{3, 1};
        System.out.println(sg.stoneGameVI(aliceValues, bobValues));
    }
}
