
public class SpecialPositionsinaBinaryMatrix {

    public int numSpecial(int[][] mat) {
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && isValidCell(mat, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isValidCell(int[][] mat, int row, int col) {
        for (int i = 0; i < mat.length; i++) {
            if (i != row && mat[i][col] == 1) {
                return false;
            }
        }
        for (int j = 0; j < mat[row].length; j++) {
            if (j != col && mat[row][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SpecialPositionsinaBinaryMatrix spbm = new SpecialPositionsinaBinaryMatrix();
        int[][] mat = new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(spbm.numSpecial(mat));
    }
}
