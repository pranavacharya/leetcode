
import java.util.HashMap;

public class MaximumNumberofBalloons {

    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> freq = new HashMap();
        for (int i = 0; i < text.length(); i++) {
            freq.put(text.charAt(i), freq.getOrDefault(text.charAt(i), 0) + 1);
        }
        int count = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            if (c == 'b' || c == 'a' || c == 'n') {
                count = Math.min(count, freq.getOrDefault(c, 0));
            } else if (c == 'l' || c == 'o') {
                int f = freq.getOrDefault(c, 0);
                if (f != 0) {
                    count = Math.min(count, f / 2);
                } else {
                    count = 0;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        MaximumNumberofBalloons mnob = new MaximumNumberofBalloons();
        System.out.println(mnob.maxNumberOfBalloons("nlaebolko"));
        System.out.println(mnob.maxNumberOfBalloons("lloo"));
        System.out.println(mnob.maxNumberOfBalloons("ballon"));
    }
}
