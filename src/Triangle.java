
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        this.dp = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(0, 0, triangle);
    }

    private int helper(int i, int j, List<List<Integer>> triangle) {
        if (j > i) {
            return 0;
        }
        if (i == triangle.size()) {
            return 0;
        }

        if (this.dp[i][j] != -1) {
            return this.dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        min = Math.min(min, helper(i + 1, j, triangle));
        min = Math.min(min, helper(i + 1, j + 1, triangle));

        return this.dp[i][j] = min + triangle.get(i).get(j);
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
