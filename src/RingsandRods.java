
public class RingsandRods {

    public int countPoints(String rings) {
        int[] freq1 = new int[10];
        int[] freq2 = new int[10];
        int[] freq3 = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            if (rings.charAt(i) == 'B') {
                freq1[rings.charAt(i + 1) - '0']++;
            } else if (rings.charAt(i) == 'G') {
                freq2[rings.charAt(i + 1) - '0']++;
            } else {
                freq3[rings.charAt(i + 1) - '0']++;
            }
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (freq1[i] > 0 && freq2[i] > 0 && freq3[i] > 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RingsandRods rr = new RingsandRods();
        System.out.println(rr.countPoints("B0B6G0R6R0R6G9"));
    }
}
