
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], -1);
        }

        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] curr = queue.poll();
                if (result[curr[0]][curr[1]] == -1) {
                    result[curr[0]][curr[1]] = distance;
                    for (int[] dir : dirs) {
                        if (curr[0] + dir[0] < matrix.length && curr[0] + dir[0] >= 0
                                && curr[1] + dir[1] >= 0 && curr[1] + dir[1] < matrix[0].length
                                && result[curr[0] + dir[0]][curr[1] + dir[1]] == -1) {
                            queue.add(new int[]{curr[0] + dir[0], curr[1] + dir[1]});
                        }
                    }
                }
                size--;
            }
            distance++;
        }
        return result;
    }

    public static void main(String args[]) {
        ZeroOneMatrix xom = new ZeroOneMatrix();
        int[][] matrix = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(xom.updateMatrix(matrix)));
    }
}
