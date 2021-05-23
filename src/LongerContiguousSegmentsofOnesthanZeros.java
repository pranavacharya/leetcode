
public class LongerContiguousSegmentsofOnesthanZeros {

    public boolean checkZeroOnes(String s) {
        int ones = 0;
        int zeros = 0;

        int localOne = 0;
        int localZero = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                localOne++;
                localZero = 0;
            } else {
                localZero++;
                localOne = 0;
            }
            ones = Math.max(ones, localOne);
            zeros = Math.max(zeros, localZero);
        }

        return ones > zeros;
    }

    public static void main(String[] args) {
        LongerContiguousSegmentsofOnesthanZeros lcsotz = new LongerContiguousSegmentsofOnesthanZeros();
        System.out.println(lcsotz.checkZeroOnes("1101"));
    }
}
