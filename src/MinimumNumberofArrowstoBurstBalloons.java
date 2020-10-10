
import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Double.compare(a[0], b[0]));
        int count = 0;
        int[] curr = points[0];
        int i = 1;
        while (i < points.length) {
            if (points[i][0] > curr[1]) {
                count++;
                curr = points[i];
            } else {
                curr = new int[]{Math.max(curr[0], points[i][0]), Math.min(curr[1], points[i][1])};
            }
            i++;
        }
        count++;
        return count;
    }

    public static void main(String args[]) {
        MinimumNumberofArrowstoBurstBalloons mnabb = new MinimumNumberofArrowstoBurstBalloons();
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(mnabb.findMinArrowShots(points));
    }
}
