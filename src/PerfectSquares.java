
import java.util.ArrayList;

public class PerfectSquares {

    private int min = Integer.MAX_VALUE;

    public int numSquares(int n) {
        ArrayList<Integer> ps = new ArrayList();
        for (int i = 1; i * i <= n; i++) {
            ps.add(i * i);
        }
        backtracking(new ArrayList(), ps, n, ps.size() - 1);
        return this.min == Integer.MAX_VALUE ? -1 : this.min;
    }

    public void backtracking(
            ArrayList<Integer> path, ArrayList<Integer> nums, int target, int index) {
        if (target == 0) {
            this.min = Math.min(this.min, path.size());
        } else if (target < 0) {
            return;
        } else {
            for (int i = index; i >= 0; i--) {
                path.add(nums.get(i));
                backtracking(path, nums, target - nums.get(i), i);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(13));
    }
}
