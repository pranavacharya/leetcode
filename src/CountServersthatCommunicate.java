
import java.util.LinkedList;
import java.util.Queue;

public class CountServersthatCommunicate {

    public int countServers(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int localcount = 0;
                Queue<int[]> bfs = new LinkedList();
                bfs.add(new int[]{i, j});
                grid[i][j] = 0;
                while (!bfs.isEmpty()) {
                    int[] cur = bfs.poll();
                    localcount++;
                    for (int row = 0; row < grid.length; row++) {
                        if (grid[row][cur[1]] == 1) {
                            grid[row][cur[1]] = 0;
                            bfs.add(new int[]{row, cur[1]});
                        }
                    }
                    for (int col = 0; col < grid[i].length; col++) {
                        if (grid[cur[0]][col] == 1) {
                            grid[cur[0]][col] = 0;
                            bfs.add(new int[]{cur[0], col});
                        }
                    }
                }
                if (localcount > 1) {
                    count += localcount;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        CountServersthatCommunicate cstc = new CountServersthatCommunicate();
        int[][] grid = new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}};
        System.out.println(cstc.countServers(grid));
    }
}
