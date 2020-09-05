
public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        int psum = 0;
        int lsum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == j) {
                    psum = psum + mat[i][j];
                }
                if (i + j == mat.length - 1) {
                    lsum = lsum + mat[i][j];
                }
            }
        }
        int ans = psum + lsum;
        if (mat.length % 2 != 0) {
            ans = ans - mat[mat.length / 2][mat.length / 2];
        }
        return ans;
    }

    public static void main(String args[]) {
        MatrixDiagonalSum mds = new MatrixDiagonalSum();
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(mds.diagonalSum(mat));
    }
}
