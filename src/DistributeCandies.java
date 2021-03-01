
import java.util.HashMap;

public class DistributeCandies {

    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> freq = new HashMap();
        for (int i = 0; i < candies.length; i++) {
            freq.put(candies[i], freq.getOrDefault(candies[i], 0) + 1);
        }
        return Math.min(candies.length / 2, freq.size());
    }

    public static void main(String args[]) {
        DistributeCandies dc = new DistributeCandies();
        int[] candies = new int[]{1, 1, 2, 3};
        System.out.println(dc.distributeCandies(candies));
    }
}
