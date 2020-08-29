
public class KthSymbolinGrammar {

    public int kthGrammar(int N, int K) {
        return generateString("0", N - 1, K);
    }

    public int generateString(String str, int N, int K) {
        if (N == 0) {
            return Integer.parseInt("" + str.charAt(K - 1));
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '0') {
                sb.append("01");
            } else {
                sb.append("10");
            }
        }
        return generateString(sb.toString(), N - 1, K);
    }

    public static void main(String args[]) {
        KthSymbolinGrammar ksg = new KthSymbolinGrammar();
        System.out.println(ksg.kthGrammar(4, 5));
    }
}
