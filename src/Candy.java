
import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int candies = 0;
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        for (int i = 0; i < candy.length; i++) {
            candies += candy[i];
        }
        return candies;
    }

    public static void main(String[] args) {
        Candy c = new Candy();
        int[] rating = new int[]{1, 2, 2};
        System.out.println(c.candy(rating));
    }
}
