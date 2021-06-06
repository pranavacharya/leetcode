
public class DetermineWhetherMatrixCanBeObtainedByRotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean status1 = true;
        boolean status2 = true;
        boolean status3 = true;
        boolean status4 = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[j][n - 1 - i]) {
                    status1 = false;
                }
                if (mat[i][j] != target[n - 1 - i][n - 1 - j]) {
                    status2 = false;
                }
                if (mat[i][j] != target[n - 1 - j][i]) {
                    status3 = false;
                }
                if (mat[i][j] != target[i][j]) {
                    status4 = false;
                }
            }
        }
        return status1 || status2 || status3 || status4;
    }

    public static void main(String[] args) {
        DetermineWhetherMatrixCanBeObtainedByRotation dwmcbr
                = new DetermineWhetherMatrixCanBeObtainedByRotation();
        int[][] mat = new int[][]{{1, 1}, {0, 1}};
        int[][] target = new int[][]{{1, 1}, {1, 0}};
        System.out.println(dwmcbr.findRotation(mat, target));
    }
}
