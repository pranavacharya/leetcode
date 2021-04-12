
import java.util.Arrays;

public class BeautifulArrangementII {

    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int l = 1;
        int r = n;
        for (int i = 0; i < n; i++) {
            if (k % 2 == 0) {
                ans[i] = l++;
            } else {
                ans[i] = r--;
            }
            if (k > 1) {
                k--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BeautifulArrangementII ba = new BeautifulArrangementII();
        System.out.println(Arrays.toString(ba.constructArray(10, 4)));
    }
}
