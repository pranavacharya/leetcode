
import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    class point {

        int x;
        int y;

        point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<point> maxHeap = new PriorityQueue<>((point a, point b) -> (squareDistanceFromOrigin(b) - squareDistanceFromOrigin(a)));
        for (int i = 0; i < points.length; i++) {
            maxHeap.add(new point(points[i][0], points[i][1]));
            if (maxHeap.size() > K) {
                maxHeap.remove();
            }
        }
        int[][] closest = new int[K][];
        for (int i = 0; i < K; i++) {
            point p = maxHeap.remove();
            closest[i] = new int[]{p.x, p.y};
        }
        return closest;
    }

    public int squareDistanceFromOrigin(point a) {
        return (a.x * a.x) + (a.y * a.y);
    }

    public static void main(String args[]) {
        KClosestPointsToOrigin kcpto = new KClosestPointsToOrigin();
        int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
//        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        System.out.println(Arrays.deepToString(kcpto.kClosest(points, 2)));
    }
}
