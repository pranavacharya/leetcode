
import java.util.Arrays;

public class DefusetheBomb {

    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k == 0) {
            return ans;
        }
        if (k > 0) {
            for (int i = 0; i < ans.length; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % code.length];
                }
                ans[i] = sum;
            }
        }
        if (k < 0) {
            k = k * -1;
            for (int i = 0; i < ans.length; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % code.length];
                }
                ans[i] = sum;
            }
            int[] res = new int[ans.length];
            for (int i = 0; i < ans.length; i++) {
                res[i] = ans[(code.length - k - 1 + i) % ans.length];
            }
            return res;
        }
        return ans;
    }

    public static void main(String args[]) {
        DefusetheBomb db = new DefusetheBomb();
        int[] code = new int[]{2, 4, 9, 3};
        System.out.println(Arrays.toString(db.decrypt(code, -3)));
    }
}
