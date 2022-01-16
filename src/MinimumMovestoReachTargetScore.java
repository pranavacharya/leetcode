
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMovestoReachTargetScore {

    public int minMoves(int target, int maxDoubles) {
        return helper(1, maxDoubles, target);
    }

    private int helper(int curr, int maxDouble, int target) {
        if (curr == target) {
            return 0;
        }
        if (maxDouble == 0) {
            return target - curr;
        }

        int count = Integer.MAX_VALUE;
        count = Math.min(count, helper(curr + 1, maxDouble, target));
        if (curr * 2 <= target) {
            count = Math.min(count, helper(curr * 2, maxDouble - 1, target));
        }
        return count + 1;
    }

    public static void main(String[] args) {
        MinimumMovestoReachTargetScore mmrts = new MinimumMovestoReachTargetScore();
        System.out.println(mmrts.minMoves(100, 4));
    }
}
