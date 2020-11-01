
import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap
                = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                minHeap.add(diff);
            }
            if (minHeap.size() > ladders) {
                bricks -= minHeap.poll();
            }
            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }

    public static void main(String args[]) {
        FurthestBuildingYouCanReach fbycr = new FurthestBuildingYouCanReach();
        int[] heights = new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19};
        System.out.println(fbycr.furthestBuilding(heights, 10, 2));
    }
}
