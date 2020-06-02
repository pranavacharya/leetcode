
import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {

    public int maxDistance(int[][] grid) {
        int max = -1;
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                queue.clear();
                int[][] visited = new int[grid.length][grid[i].length];
                queue.add(new int[]{i, j, 0});
                visited[i][j] = 1;
                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    int curx = current[0];
                    int cury = current[1];
                    if (curx - 1 >= 0 && visited[curx - 1][cury] == 0) {
                        if (grid[curx - 1][cury] == 1) {
                            max = Math.max(max, calDistance(i, j, curx - 1, cury));
                            break;
                        }
                        visited[curx - 1][cury] = 1;
                        queue.add(new int[]{curx - 1, cury});
                    }
                    if (cury - 1 >= 0 && visited[curx][cury - 1] == 0) {
                        if (grid[curx][cury - 1] == 1) {
                            max = Math.max(max, calDistance(i, j, curx, cury - 1));
                            break;
                        }
                        visited[curx][cury - 1] = 1;
                        queue.add(new int[]{curx, cury - 1});
                    }
                    if (curx + 1 < grid.length && visited[curx + 1][cury] == 0) {
                        if (grid[curx + 1][cury] == 1) {
                            max = Math.max(max, calDistance(i, j, curx + 1, cury));
                            break;
                        }
                        visited[curx + 1][cury] = 1;
                        queue.add(new int[]{curx + 1, cury});
                    }
                    if (cury + 1 < grid[curx].length && visited[curx][cury + 1] == 0) {
                        if (grid[curx][cury + 1] == 1) {
                            max = Math.max(max, calDistance(i, j, curx, cury + 1));
                            break;
                        }
                        visited[curx][cury + 1] = 1;
                        queue.add(new int[]{curx, cury + 1});
                    }
                }
            }
        }
        return max;
    }

    private int calDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String args[]) {
        AsFarfromLandasPossible afflp = new AsFarfromLandasPossible();
        int[][] grid = new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(afflp.maxDistance(grid));
    }
}
