
import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (-(a[0] * a[0] + a[1] * a[1])
                + (b[0] * b[0] + b[1] * b[1])));
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            ans[i++] = maxHeap.poll();
        }
        return ans;
    }

    public static void main(String args[]) {
        KClosestPointsToOrigin kcpto = new KClosestPointsToOrigin();
        int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
//        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        System.out.println(Arrays.deepToString(kcpto.kClosest(points, 2)));
    }
}
