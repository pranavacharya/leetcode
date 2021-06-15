
public class MatchstickstoSquare {

    public boolean makesquare(int[] matchsticks) {
        int perimeter = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            perimeter += matchsticks[i];
        }
        if (perimeter % 4 != 0) {
            return false;
        }
        int side = perimeter / 4;
        return backtracking(matchsticks, side, 0, 0, 0, 0, 0);
    }

    private boolean backtracking(int[] matches, int side, int index, int sum1, int sum2, int sum3, int sum4) {
        if (side == sum1 && side == sum2 && side == sum3 && side == sum4) {
            return true;
        }
        if (index == matches.length) {
            return false;
        }
        int len = matches[index];
        if (sum1 + len <= side) {
            if (backtracking(matches, side, index + 1, sum1 + len, sum2, sum3, sum4)) {
                return true;
            }
        }
        if (sum2 + len <= side) {
            if (backtracking(matches, side, index + 1, sum1, sum2 + len, sum3, sum4)) {
                return true;
            }
        }
        if (sum3 + len <= side) {
            if (backtracking(matches, side, index + 1, sum1, sum2, sum3 + len, sum4)) {
                return true;
            }
        }
        if (sum4 + len <= side) {
            if (backtracking(matches, side, index + 1, sum1, sum2, sum3, sum4 + len)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MatchstickstoSquare mss = new MatchstickstoSquare();
        int[] matchsticks = new int[]{1, 1, 2, 2, 2};
        System.out.println(mss.makesquare(matchsticks));
    }
}
