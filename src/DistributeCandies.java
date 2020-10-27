
import java.util.HashMap;

public class DistributeCandies {

    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> frequency = new HashMap();
        for (int i = 0; i < candies.length; i++) {
            frequency.put(candies[i], frequency.getOrDefault(candies[i], 0) + 1);
        }
        return candies.length / 2 > frequency.size() ? frequency.size() : candies.length / 2;
    }

    public static void main(String args[]) {
        DistributeCandies dc = new DistributeCandies();
        int[] candies = new int[]{1, 1, 2, 3};
        System.out.println(dc.distributeCandies(candies));
    }
}
