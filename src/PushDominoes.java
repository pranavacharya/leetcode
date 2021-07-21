
import java.util.Arrays;

public class PushDominoes {

    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        Arrays.fill(prefix, Integer.MAX_VALUE);
        Arrays.fill(suffix, Integer.MAX_VALUE);
        boolean isRight = false;
        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == 'R') {
                prefix[i] = 1;
                isRight = true;
            } else if (c != 'L' && isRight) {
                prefix[i] = prefix[i - 1] + 1;
            } else if (c == 'L') {
                isRight = false;
            }
        }
        boolean isLeft = false;
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                suffix[i] = 1;
                isLeft = true;
            } else if (c != 'R' && isLeft) {
                suffix[i] = suffix[i + 1] + 1;
            } else if (c == 'R') {
                isLeft = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i]) {
                sb.append('.');
            } else if (prefix[i] > suffix[i]) {
                sb.append('L');
            } else {
                sb.append('R');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PushDominoes pd = new PushDominoes();
        System.out.println(pd.pushDominoes(".L.R...LR..L.."));
    }
}
