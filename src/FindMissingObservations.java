
import java.util.Arrays;

public class FindMissingObservations {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] ans = new int[n];

        int sum = 0;
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }
        int x = mean * (rolls.length + n) - sum;
        if (6 * n >= x && x >= n) {
            int start = x / n;
            for (int i = 0; i < n; i++) {
                ans[i] = start;
            }
            x = x % n;
            int i = 0;
            while (x > 0) {
                ans[i]++;
                x--;
                i++;
            }
        } else {
            return new int[]{};
        }
        return ans;
    }

    public static void main(String[] args) {
        FindMissingObservations fmo = new FindMissingObservations();
        int[] rolls = new int[]{3, 2, 4, 3};
        System.out.println(Arrays.toString(fmo.missingRolls(rolls, 4, 2)));
    }
}
