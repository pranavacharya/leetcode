
public class MinimumChangesToMakeAlternatingBinaryString {

    public int minOperations(String s) {
        int oddOne = 0;
        int oddZero = 0;
        int evenOne = 0;
        int evenZero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    evenZero++;
                } else {
                    evenOne++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    oddZero++;
                } else {
                    oddOne++;
                }
            }
        }

        return Math.min(oddOne + evenZero, oddZero + evenOne);
    }

    public static void main(String args[]) {
        MinimumChangesToMakeAlternatingBinaryString mctmabs
                = new MinimumChangesToMakeAlternatingBinaryString();
        System.out.println(mctmabs.minOperations("0100"));
    }
}
