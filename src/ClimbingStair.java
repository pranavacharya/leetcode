
public class ClimbingStair {

    public static int count = 0;

    public static void stair(int totalSoFar, int[] steps, int target) {
        if (totalSoFar == target) {
            count++;
        } else {
            for (int i : steps) {
                if (!(totalSoFar + i > target)) {
                    stair(totalSoFar + i, steps, target);
                }
            }
        }
    }

    public int climbStairs(int n) {
        int[] steps = {1, 2};
        stair(0, steps, n);
        return count;
    }

    public static void main(String args[]) {
        ClimbingStair cs = new ClimbingStair();
        System.out.println(cs.climbStairs(3));
    }
}
