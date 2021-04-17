
import java.util.Arrays;

public class QueriesonNumberofPointsInsideaCircle {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int cx = query[0];
            int cy = query[1];
            int r = query[2];
            int count = 0;
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                if (isInsideCircle(cx, cy, r, x, y)) {
                    count++;
                }
            }
            ans[index++] = count;
        }
        return ans;
    }

    private boolean isInsideCircle(int cx, int cy, int r, int x, int y) {
        double distanceSqr = Math.pow(Math.abs(cx - x), 2) + Math.pow(Math.abs(cy - y), 2);
        return distanceSqr <= Math.pow(r, 2);
    }

    public static void main(String args[]) {
        QueriesonNumberofPointsInsideaCircle qnpic = new QueriesonNumberofPointsInsideaCircle();
        int[][] points = new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        System.out.println(Arrays.toString(qnpic.countPoints(points, queries)));
    }
}
