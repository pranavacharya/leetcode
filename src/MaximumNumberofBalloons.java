
import java.util.HashMap;

public class MaximumNumberofBalloons {

    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> frequency = new HashMap();
        frequency.put('b', 0);
        frequency.put('a', 0);
        frequency.put('l', 0);
        frequency.put('o', 0);
        frequency.put('n', 0);
        for (char c : text.toCharArray()) {
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }
        }
        int count = text.length();
        for (char c : frequency.keySet()) {
            if (c == 'l' || c == 'o') {
                count = Math.min(count, (frequency.get(c) / 2));
            } else {
                count = Math.min(count, frequency.get(c));
            }
        }
        return count;
    }

    public static void main(String args[]) {
        MaximumNumberofBalloons mnob = new MaximumNumberofBalloons();
        System.out.println(mnob.maxNumberOfBalloons("nlaebolko"));
        System.out.println(mnob.maxNumberOfBalloons("lloo"));
    }
}
