
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        int[][] arr = new int[numRows + 1][numRows + 1];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }

        List<List<Integer>> triangle = new ArrayList();
        for (int i = 1; i < arr.length; i++) {
            int[] row = arr[i];
            List<Integer> rowList = new ArrayList();
            for (int num : row) {
                if (num != 0) {
                    rowList.add(num);
                }
            }
            triangle.add(rowList);
        }
        return triangle;
    }

    public static void main(String args[]) {
        PascalsTriangle pt = new PascalsTriangle();
        System.out.println(pt.generate(5));
        System.out.println(pt.generate(7));
    }
}
