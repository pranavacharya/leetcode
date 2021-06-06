
public class MinimumNumberofFlipstoMaketheBinaryStringAlternating {

    public int minFlips(String s) {
        int n = s.length();
        int diff1 = 0;
        int diff2 = 0;
        int ans = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < 2 * n; j++) {
            char startWith0 = j % 2 == 0 ? '0' : '1';
            char startWith1 = j % 2 == 0 ? '1' : '0';
            char curr = s.charAt(j % n);
            if (curr != startWith0) {
                diff1++;
            }
            if (curr != startWith1) {
                diff2++;
            }
            if (j - i + 1 == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
                char startWindowwith0 = i % 2 == 0 ? '0' : '1';
                char startWindowwith1 = i % 2 == 0 ? '1' : '0';
                if (s.charAt(i % n) != startWindowwith0) {
                    diff1--;
                }
                if (s.charAt(i % n) != startWindowwith1) {
                    diff2--;
                }
                i++;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        MinimumNumberofFlipstoMaketheBinaryStringAlternating mnfmbsa
                = new MinimumNumberofFlipstoMaketheBinaryStringAlternating();
        System.out.println(mnfmbsa.minFlips("01001001101"));
    }
}
