
public class FindNearestPointThatHastheSameXorYCoordinate {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                double distance = calDistance(x, y, points[i][0], points[i][1]);
                if (distance < min) {
                    min = distance;
                    ans = i;
                }
            }
        }
        return ans;
    }

    public double calDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] args) {
        FindNearestPointThatHastheSameXorYCoordinate fnpthsc
                = new FindNearestPointThatHastheSameXorYCoordinate();
        int[][] points = new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        System.out.println(fnpthsc.nearestValidPoint(3, 4, points));
    }
}
