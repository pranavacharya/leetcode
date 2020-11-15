
public class MinimumDeletionstoMakeStringBalanced {

    public int minimumDeletions(String s) {
        int[] abefore = new int[s.length()];
        int[] bafter = new int[s.length()];
        for (int i = 0; i < abefore.length; i++) {
            if (i == 0) {
                abefore[i] = 0;
            } else {
                abefore[i] = abefore[i - 1];
            }
            if (s.charAt(i) == 'a') {
                abefore[i]++;
            }
        }
        for (int i = bafter.length - 1; i >= 0; i--) {
            if (i == bafter.length - 1) {
                bafter[i] = 0;
            } else {
                bafter[i] = bafter[i + 1];
            }
            if (s.charAt(i) == 'b') {
                bafter[i]++;
            }
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, abefore[i] + bafter[i]);
        }
        return s.length() - max;
    }

    public static void main(String args[]) {
        MinimumDeletionstoMakeStringBalanced mdmsb = new MinimumDeletionstoMakeStringBalanced();
        System.out.println(mdmsb.minimumDeletions("aababbab"));
    }
}
