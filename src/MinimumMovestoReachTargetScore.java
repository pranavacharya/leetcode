
public class MinimumMovestoReachTargetScore {

    public int minMoves(int target, int maxDoubles) {
        int moves = 0;

        if (target != 1 && target % 2 == 1) {
            moves++;
            target--;
        }

        while (target > 1) {
            if (maxDoubles > 0) {
                maxDoubles--;
                target /= 2;
                moves++;
            } else {
                moves += (target - 1);
                target = 1;
            }

            if (target != 1 && target % 2 == 1) {
                target--;
                moves++;
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        MinimumMovestoReachTargetScore mmrts = new MinimumMovestoReachTargetScore();
        System.out.println(mmrts.minMoves(1, 4));
    }
}
