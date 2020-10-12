
public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        if (points.length == 0) {
            return 0;
        }
        int[] current = points[0];
        for (int i = 1; i < points.length; i++) {
            int xDiff = Math.abs(current[0] - points[i][0]);
            int yDiff = Math.abs(current[1] - points[i][1]);
            int common = Math.min(xDiff, yDiff);
            int local = common + Math.abs(xDiff - yDiff);
            time += local;
            current = points[i];
        }
        return time;
    }

    public static void main(String args[]) {
        MinimumTimeVisitingAllPoints mtvap = new MinimumTimeVisitingAllPoints();
        int[][] points = new int[][]{{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(mtvap.minTimeToVisitAllPoints(points));
    }
}
