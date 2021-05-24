
import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int[] pref = new int[ratings.length];
        int[] suff = new int[ratings.length];
        Arrays.fill(pref, 1);
        Arrays.fill(suff, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                pref[i] = pref[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                suff[i] = suff[i + 1] + 1;
            }
        }
        int count = 0;
        for (int i = 0; i < pref.length; i++) {
            count += Math.max(pref[i], suff[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        Candy c = new Candy();
        int[] rating = new int[]{1, 2, 2};
        System.out.println(c.candy(rating));
    }
}
