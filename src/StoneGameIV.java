
public class StoneGameIV {

    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        for (int i = 2; i < dp.length; i++) {
            boolean flag = true;
            for (int j = 1; j < 100000; j++) {
                int val = j * j;
                if (i - val < 0) {
                    break;
                } else {
                    if (!dp[i - val]) {
                        flag = false;
                        dp[i] = true;
                        break;
                    }
                }
            }
            if (flag) {
                dp[i] = false;
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String args[]) {
        StoneGameIV sg = new StoneGameIV();
        System.out.println(sg.winnerSquareGame(2));
        System.out.println(sg.winnerSquareGame(5));
        System.out.println(sg.winnerSquareGame(4));
        System.out.println(sg.winnerSquareGame(16));
        System.out.println(sg.winnerSquareGame(7));
        System.out.println(sg.winnerSquareGame(17));
    }
}
