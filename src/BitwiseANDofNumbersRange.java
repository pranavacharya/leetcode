
public class BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int ans = m;
        for (int i = m + 1; i <= n && i < Integer.MAX_VALUE && i >= 0; i++) {
            ans = ans & i;
            if (ans == 0) {
                return 0;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        BitwiseANDofNumbersRange banr = new BitwiseANDofNumbersRange();
        System.out.println(banr.rangeBitwiseAnd(5, 7));
    }
}
