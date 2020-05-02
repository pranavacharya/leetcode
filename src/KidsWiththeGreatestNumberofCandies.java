
import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> result = new ArrayList();
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }

    public static void main(String args[]) {
        KidsWiththeGreatestNumberofCandies kwthgnoc = new KidsWiththeGreatestNumberofCandies();
        int[] candies = new int[]{2, 3, 5, 1, 3};
        System.out.println(kwthgnoc.kidsWithCandies(candies, 3));
    }
}
