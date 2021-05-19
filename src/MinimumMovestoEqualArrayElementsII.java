
import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        int moves = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            moves += (nums[nums.length - 1 - i] - nums[i]);
        }
        return moves;
    }

    public static void main(String[] args) {
        MinimumMovestoEqualArrayElementsII mmea = new MinimumMovestoEqualArrayElementsII();
        int[] nums = new int[]{1, 0, 0, 8, 6};
        System.out.println(mmea.minMoves2(nums));
    }
}
