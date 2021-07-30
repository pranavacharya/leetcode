
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList();
                    boolean[][] visited = new boolean[mat.length][mat[0].length];
                    int dist = 0;
                    queue.add(new int[]{i, j});
                    outer:
                    while (!queue.isEmpty()) {
                        dist++;
                        int size = queue.size();
                        while (size > 0) {
                            int[] curr = queue.poll();
                            visited[curr[0]][curr[1]] = true;
                            for (int[] dir : dirs) {
                                int x = curr[0] + dir[0];
                                int y = curr[1] + dir[1];
                                if (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && !visited[x][y]) {
                                    if (mat[x][y] == 1) {
                                        queue.add(new int[]{x, y});
                                        visited[x][y] = true;
                                    } else {
                                        break outer;
                                    }
                                }
                            }
                            size--;
                        }
                    }
                    ans[i][j] = dist;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        ZeroOneMatrix xom = new ZeroOneMatrix();
        int[][] matrix = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(xom.updateMatrix(matrix)));
    }
}
