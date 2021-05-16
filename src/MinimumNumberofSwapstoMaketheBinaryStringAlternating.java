
public class MinimumNumberofSwapstoMaketheBinaryStringAlternating {

    public int minSwaps(String s) {
        int ones = 0;
        int zeros = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
        if (Math.abs(ones - zeros) > 1) {
            return -1;
        }

        if (ones == zeros) {
            return Math.min(findSwaps(s, true), findSwaps(s, false));
        } else {
            if (ones > zeros) {
                return findSwaps(s, false);
            } else {
                return findSwaps(s, true);
            }
        }
    }

    private int findSwaps(String s, boolean isZeroFirst) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isZeroFirst) {
                if (i % 2 == 0 && s.charAt(i) == '1') {
                    diff++;
                } else if (i % 2 == 1 && s.charAt(i) == '0') {
                    diff++;
                }
            } else {
                if (i % 2 == 0 && s.charAt(i) == '0') {
                    diff++;
                } else if (i % 2 == 1 && s.charAt(i) == '1') {
                    diff++;
                }
            }
        }
        return diff / 2;
    }

    public static void main(String[] args) {
        MinimumNumberofSwapstoMaketheBinaryStringAlternating mnsmssa = new MinimumNumberofSwapstoMaketheBinaryStringAlternating();
        System.out.println(mnsmssa.minSwaps("1110000"));
    }
}
