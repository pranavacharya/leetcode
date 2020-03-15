
import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInAMatrix {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int minrow = 0;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minrow = j;
                }
            }
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][minrow] > max) {
                    max = matrix[k][minrow];
                }
            }
            if (max == min) {
                ans.add(max);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        LuckyNumberInAMatrix lniam = new LuckyNumberInAMatrix();
        int[][] matrix = new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println(lniam.luckyNumbers(matrix));
    }
}
