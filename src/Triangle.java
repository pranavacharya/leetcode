
import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {

                if (j != 0 && j != row.size() - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                }

                if (j == row.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                dp[i][j] += row.get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<List<Integer>> tri = new ArrayList();
        List<Integer> one = new ArrayList();
        one.add(2);
        List<Integer> two = new ArrayList();
        two.add(3);
        two.add(4);
        List<Integer> three = new ArrayList();
        three.add(6);
        three.add(5);
        three.add(7);
        List<Integer> four = new ArrayList();
        four.add(4);
        four.add(1);
        four.add(8);
        four.add(3);
        tri.add(one);
        tri.add(two);
        tri.add(three);
        tri.add(four);
        System.out.println(t.minimumTotal(tri));
    }
}
