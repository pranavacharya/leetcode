
import java.util.LinkedList;
import java.util.Queue;

public class NearestExitfromEntranceinMaze {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int distance = 0;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{entrance[0], entrance[1]});
        boolean isFirst = true;
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX < 0 || newY < 0 || newX >= maze.length || newY >= maze[0].length) {
                        if (!isFirst) {
                            return distance;
                        }
                    }
                    if (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length && maze[newX][newY] == '.') {
                        maze[newX][newY] = '+';
                        queue.add(new int[]{newX, newY});
                    }
                }
                isFirst = false;
                size--;
            }
            distance++;
        }
        return -1;
    }

    public static void main(String[] args) {
        NearestExitfromEntranceinMaze nefem = new NearestExitfromEntranceinMaze();
        char[][] maze = new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance = new int[]{1, 2};
        System.out.println(nefem.nearestExit(maze, entrance));
    }
}
