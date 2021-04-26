
import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 1; i < heights.length; i++) {
            int bricksNeeded = heights[i] - heights[i - 1];
            if (bricksNeeded > 0) {
                if (bricks < bricksNeeded) {
                    if (ladders <= 0) {
                        return i - 1;
                    } else {
                        if (!maxHeap.isEmpty() && maxHeap.peek() > bricksNeeded) {
                            bricks += maxHeap.poll();
                            maxHeap.add(bricksNeeded);
                            bricks -= bricksNeeded;
                        }
                        ladders--;
                    }
                } else {
                    maxHeap.add(bricksNeeded);
                    bricks -= bricksNeeded;
                }
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
