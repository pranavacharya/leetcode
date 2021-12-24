
public class FlipStringtoMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int[] suffix = new int[s.length() + 1];
        int[] prefix = new int[s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                suffix[i] = suffix[i + 1] + 1;
            } else {
                suffix[i] = suffix[i + 1];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                prefix[i + 1] = prefix[i] + 1;
            } else {
                prefix[i + 1] = prefix[i];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= s.length(); i++) {
            min = Math.min(min, suffix[i] + prefix[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        FlipStringtoMonotoneIncreasing fsmi = new FlipStringtoMonotoneIncreasing();
        System.out.println(fsmi.minFlipsMonoIncr("00011000"));
    }
}
