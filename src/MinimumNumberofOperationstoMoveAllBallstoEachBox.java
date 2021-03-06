
import java.util.Arrays;

public class MinimumNumberofOperationstoMoveAllBallstoEachBox {

    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];

        for (int i = 0; i < boxes.length(); i++) {
            int ops = 0;
            for (int j = 0; j < boxes.length(); j++) {
                if (boxes.charAt(j) == '1') {
                    ops += Math.abs(j - i);
                }
            }
            ans[i] = ops;
        }
        return ans;
    }

    public static void main(String args[]) {
        MinimumNumberofOperationstoMoveAllBallstoEachBox mnombb
                = new MinimumNumberofOperationstoMoveAllBallstoEachBox();
        System.out.println(Arrays.toString(mnombb.minOperations("110")));
    }
}
