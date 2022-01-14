
import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Double.compare(a[0], b[0]));

        int min = 0;
        int last[] = points[0];
        min++;
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];

            if (curr[0] > last[1]) {
                min++;
                last = curr;
            } else {
                last[1] = Math.min(curr[1], last[1]);
            }
        }

        return min;
    }

    public static void main(String args[]) {
        MinimumNumberofArrowstoBurstBalloons mnabb = new MinimumNumberofArrowstoBurstBalloons();
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(mnabb.findMinArrowShots(points));
    }
}
