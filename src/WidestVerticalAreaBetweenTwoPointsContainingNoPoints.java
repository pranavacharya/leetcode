
import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public int maxWidthOfVerticalArea(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Double.compare(a[0], b[0]));
        int max = 0;
        int width = 0;
        int last = points[0][0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] != last) {
                max = Math.max(max, points[i][0] - last);
                last = points[i][0];
            }
        }
        return max;
    }

    public static void main(String args[]) {
        WidestVerticalAreaBetweenTwoPointsContainingNoPoints wvabtpcnp
                = new WidestVerticalAreaBetweenTwoPointsContainingNoPoints();
        int[][] points = new int[][]{{8, 7}, {9, 9}, {7, 4}, {9, 7}};
        System.out.println(wvabtpcnp.maxWidthOfVerticalArea(points));
    }
}
