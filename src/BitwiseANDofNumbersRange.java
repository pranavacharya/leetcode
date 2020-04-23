
public class BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int ans = m;
        for (int i = m + 1; i <= n; i++) {
            ans = ans & i;
        }
        return ans;
    }

    public static void main(String args[]) {
        BitwiseANDofNumbersRange banr = new BitwiseANDofNumbersRange();
        System.out.println(banr.rangeBitwiseAnd(5, 7));
    }
}
