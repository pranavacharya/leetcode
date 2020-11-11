
import java.util.HashSet;

public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Double> distance = new HashSet();
        int[][] points = new int[][]{p1, p2, p3, p4};
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                distance.add(distance(points[i][0], points[i][1], points[j][0], points[j][1]));
            }
        }
        return distance.size() == 2 && !distance.contains(0.0);
    }

    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2));
    }

    public static void main(String args[]) {
        ValidSquare vs = new ValidSquare();
        int[] p1 = new int[]{0, 0};
        int[] p2 = new int[]{1, 1};
        int[] p3 = new int[]{1, 0};
        int[] p4 = new int[]{0, 1};
        System.out.println(vs.validSquare(p1, p2, p3, p4));
    }
}
