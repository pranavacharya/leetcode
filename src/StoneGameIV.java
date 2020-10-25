
public class StoneGameIV {

    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                int val = j * j;
                if (!dp[i - val]) {
                    dp[i] = true;
                    break;
                }
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
