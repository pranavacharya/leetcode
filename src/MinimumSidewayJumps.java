
public class MinimumSidewayJumps {

    private int minJumps = Integer.MAX_VALUE;

    public int minSideJumps(int[] obstacles) {
        dfs(1, 0, obstacles, 0);
        return this.minJumps == Integer.MAX_VALUE ? - 1 : this.minJumps;
    }

    private void dfs(int lane, int point, int[] obstacles, int jumps) {
        if (point == obstacles.length - 1) {
            this.minJumps = Math.min(this.minJumps, jumps);
            return;
        }
        if (obstacles[point + 1] != 0 && obstacles[point + 1] == lane + 1) {
            if (obstacles[point] != (lane + 1) % 3 + 1) {
                dfs((lane + 1) % 3, point, obstacles, jumps + 1);
            }
            if (obstacles[point] != (lane + 2) % 3 + 1) {
                dfs((lane + 2) % 3, point, obstacles, jumps + 1);
            }
        } else {
            dfs(lane, point + 1, obstacles, jumps);
        }
    }

    public static void main(String[] args) {
        MinimumSidewayJumps msj = new MinimumSidewayJumps();
        int[] obstacles = new int[]{0, 2, 2, 1, 0, 3, 0, 3, 0, 1, 0};
        System.out.println(msj.minSideJumps(obstacles));
    }
}
