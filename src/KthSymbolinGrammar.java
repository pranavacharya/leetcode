
public class KthSymbolinGrammar {

    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        return generateString(N, K);
    }

    public int generateString(int N, int K) {
        if (N == 2) {
            if (K == 1) {
                return 0;
            } else {
                return 1;
            }
        }
        boolean odd = false;
        if (K % 2 == 1) {
            K++;
            odd = true;
        }
        int val = generateString(N - 1, K / 2);
        if (odd && val == 0 || !odd && val == 1) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String args[]) {
        KthSymbolinGrammar ksg = new KthSymbolinGrammar();
        System.out.println(ksg.kthGrammar(4, 3));
    }
}
