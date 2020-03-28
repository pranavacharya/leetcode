
import java.util.HashSet;

public class SetMatrixZero {

    public void setZeroes(int[][] matrix) {
        HashSet<Integer> column = new HashSet<>();
        HashSet<Integer> row = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    column.add(j);
                    row.add(i);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row.contains(i) || column.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
//        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String args[]) {
        SetMatrixZero sme = new SetMatrixZero();
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        sme.setZeroes(matrix);
    }
}
