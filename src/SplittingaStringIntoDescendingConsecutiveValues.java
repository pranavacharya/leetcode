
public class SplittingaStringIntoDescendingConsecutiveValues {

    public boolean splitString(String s) {
        return helper(s, 0, null);
    }

    private boolean helper(String s, int i, Long prev) {
        if (i == s.length()) {
            return true;
        }
        long val = 0;
        for (int j = i; j < s.length(); j++) {
            val = val * 10 + (s.charAt(j) - '0');
            if (prev == null || (prev > val && Math.abs(prev - val) == 1)) {
                if (j == s.length() - 1 && prev == null) {
                    continue;
                }
                if (helper(s, j + 1, val)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        SplittingaStringIntoDescendingConsecutiveValues ssdcv = new SplittingaStringIntoDescendingConsecutiveValues();
        System.out.println(ssdcv.splitString("050043"));
        System.out.println(ssdcv.splitString("9080701"));
        System.out.println(ssdcv.splitString("10009998"));
    }
}
