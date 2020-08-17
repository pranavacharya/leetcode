
import java.util.Arrays;

public class DistributeCandiestoPeople {

    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int index = 0;
        int count = 1;
        while (candies > 0) {
            ans[index] += count;
            candies -= count;
            count++;
            if (candies < count) {
                count = candies;
            }
            index++;
            index = index % num_people;
        }
        return ans;
    }

    public static void main(String args[]) {
        DistributeCandiestoPeople dcp = new DistributeCandiestoPeople();
        int candies = 7;
        int num_people = 4;
        System.out.println(Arrays.toString(dcp.distributeCandies(candies, num_people)));
    }
}
