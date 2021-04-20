
import java.util.Arrays;
import java.util.HashMap;

public class CanIWin {

    HashMap<String, Boolean> dp;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.dp = new HashMap();
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        // no winner
        if (((maxChoosableInteger + 1) * maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        return helper(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger + 1]);
    }

    private boolean helper(int max, int desired, boolean[] visited) {

        if (desired <= 0) {
            return false;
        }

        String key = Arrays.toString(visited);

        if (this.dp.containsKey(key)) {
            return this.dp.get(key);
        }

        for (int i = 1; i < visited.length; i++) {

            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            boolean status = helper(max, desired - i, visited);
            if (!status) {
                visited[i] = false;
                this.dp.put(key, true);
                return true;
            }
            visited[i] = false;
        }
        this.dp.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        CanIWin cw = new CanIWin();
        System.out.println(cw.canIWin(5, 50));
        System.out.println(cw.canIWin(10, 11));
        System.out.println(cw.canIWin(10, 1));
        System.out.println(cw.canIWin(10, 0));
        System.out.println(cw.canIWin(10, 40));
        System.out.println(cw.canIWin(20, 189));
    }
}
