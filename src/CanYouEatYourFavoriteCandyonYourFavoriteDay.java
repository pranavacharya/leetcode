
import java.util.Arrays;

public class CanYouEatYourFavoriteCandyonYourFavoriteDay {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        long[] prefix = new long[candiesCount.length];
        prefix[0] = candiesCount[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + candiesCount[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int favType = queries[i][0];
            int favDay = queries[i][1];
            int cap = queries[i][2];
            long min = (favType == 0 ? 0 : prefix[favType - 1]) / cap;
            long max = prefix[favType] - 1;
            ans[i] = favDay <= max && favDay >= min;
        }

        return ans;
    }

    public static void main(String args[]) {
        CanYouEatYourFavoriteCandyonYourFavoriteDay cyeyfcyd = new CanYouEatYourFavoriteCandyonYourFavoriteDay();
        int[] candiesCount = new int[]{5, 2, 6, 4, 1};
        int[][] queries = new int[][]{{4, 10, 3}};
        System.out.println(Arrays.toString(cyeyfcyd.canEat(candiesCount, queries)));
    }
}
