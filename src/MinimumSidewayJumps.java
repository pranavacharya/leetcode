
import java.util.Arrays;

public class MinimumSidewayJumps {

    int[][] memo;

    public int minSideJumps(int[] obstacles) {
        this.memo = new int[3][obstacles.length];
        for (int i = 0; i < this.memo.length; i++) {
            Arrays.fill(this.memo[i], -1);
        }
        return dfs(1, 0, obstacles);
    }

    private int dfs(int lane, int point, int[] obstacles) {
        if (this.memo[lane][point] != -1) {
            return this.memo[lane][point];
        }
        if (point == obstacles.length - 1) {
            return 0;
        }
        int jump = 0;
        if (obstacles[point + 1] != 0 && obstacles[point + 1] == lane + 1) {
            jump++;
            int options = Integer.MAX_VALUE;
            if (obstacles[point] != (lane + 1) % 3 + 1) {
                options = Math.min(options, dfs((lane + 1) % 3, point, obstacles));
            }
            if (obstacles[point] != (lane + 2) % 3 + 1) {
                options = Math.min(options, dfs((lane + 2) % 3, point, obstacles));
            }
            jump += options;
        } else {
            jump = dfs(lane, point + 1, obstacles);
        }
        this.memo[lane][point] = jump;
        return jump;
    }

    public static void main(String[] args) {
        MinimumSidewayJumps msj = new MinimumSidewayJumps();
        int[] obstacles = new int[]{0, 2, 2, 1, 0, 3, 0, 3, 0, 1, 0};
        System.out.println(msj.minSideJumps(obstacles));
    }
}
