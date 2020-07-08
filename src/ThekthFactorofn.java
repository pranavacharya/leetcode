
public class ThekthFactorofn {

    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                k--;
            }
            if (k == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        ThekthFactorofn tkfn = new ThekthFactorofn();
        System.out.println(tkfn.kthFactor(12, 3));
    }
}
