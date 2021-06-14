
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < ans.length; i++) {
            Arrays.fill(ans[i], -1);
        }
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] curr = queue.poll();
                if (ans[curr[0]][curr[1]] == -1) {
                    ans[curr[0]][curr[1]] = dist;
                    for (int[] dir : dirs) {
                        int x = curr[0] + dir[0];
                        int y = curr[1] + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && ans[x][y] == -1) {
                            queue.add(new int[]{x, y});
                        }
                    }
                }
                size--;
            }
            dist++;
        }
        return ans;
    }

    public static void main(String args[]) {
        ZeroOneMatrix xom = new ZeroOneMatrix();
        int[][] matrix = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(xom.updateMatrix(matrix)));
    }
}
