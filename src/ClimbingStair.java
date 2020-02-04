
public class ClimbingStair {

    public static int stair(int count, int totalSoFar, int[] steps, int target) {
        if (totalSoFar > target) {
            return 0;
        }
        if (totalSoFar == target) {
            return 1;
        } else {
            count = stair(count, totalSoFar + 1, steps, target) + stair(count, totalSoFar + 2, steps, target);
            return count;
        }
    }

    public int climbStairs(int n) {
        int[] steps = {1, 2};
        return stair(0, 0, steps, n);
    }

    public static void main(String args[]) {
        ClimbingStair cs = new ClimbingStair();
        System.out.println(cs.climbStairs(3));
    }
}
