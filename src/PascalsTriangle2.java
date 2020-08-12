
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        int[][] triangle = new int[rowIndex + 1][rowIndex + 1];
        triangle[0][0] = 1;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }
        List<Integer> result = new ArrayList();
        for (int i = 0; i < triangle[rowIndex].length; i++) {
            result.add(triangle[rowIndex][i]);
        }
        return result;
    }

    public static void main(String args[]) {
        PascalsTriangle2 pt2 = new PascalsTriangle2();
        System.out.println(pt2.getRow(3));
    }
}
