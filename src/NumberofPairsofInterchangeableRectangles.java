
import java.util.HashMap;

public class NumberofPairsofInterchangeableRectangles {

    public long interchangeableRectangles(int[][] rectangles) {
        long ans = 0;
        HashMap<Double, Integer> map = new HashMap();
        for (int i = 0; i < rectangles.length; i++) {
            double ratio = (double) rectangles[i][0] / (double) rectangles[i][1];
            if (map.containsKey(ratio)) {
                ans += map.get(ratio);
            }
            map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberofPairsofInterchangeableRectangles npir = new NumberofPairsofInterchangeableRectangles();
//        int[][] rectangles = new int[][]{{4, 5}, {7, 8}};
        int[][] rectangles = new int[][]{{4, 8}, {3, 6}, {10, 20}, {15, 30}};
        System.out.println(npir.interchangeableRectangles(rectangles));
    }
}
