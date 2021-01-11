
import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {

    public int maximumGain(String s, int x, int y) {
        int start = 0;
        int end = 0;
        int maxGain = 0;
        while (end < s.length()) {
            end = start;
            while (end < s.length()) {
                if (s.charAt(end) == 'a' || s.charAt(end) == 'b') {
                    end++;
                } else {
                    break;
                }
            }
            maxGain += findGain(s.substring(start, end), x, y);
            start = end + 1;
        }
        return maxGain;
    }

    private int findGain(String s, int x, int y) {
        int gain = 0;
        int as = 0;
        int bs = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                as++;
            } else {
                bs++;
            }
        }
        int maxPairs = Math.min(as, bs);
        Stack<Character> stack = new Stack();
        int pairs = 0;
        if (x > y) {
            for (int i = 0; i < s.length(); i++) {
                if (stack.isEmpty()) {
                    stack.push(s.charAt(i));

                } else if (s.charAt(i) == 'b') {
                    if (stack.peek() == 'a') {
                        stack.pop();
                        gain += x;
                        pairs++;
                    } else {
                        stack.push(s.charAt(i));
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
            int diff = maxPairs - pairs;
            gain += diff * y;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (stack.isEmpty()) {
                    stack.push(s.charAt(i));

                } else if (s.charAt(i) == 'a') {
                    if (stack.peek() == 'b') {
                        stack.pop();
                        gain += y;
                        pairs++;
                    } else {
                        stack.push(s.charAt(i));
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
            int diff = maxPairs - pairs;
            gain += diff * x;
        }
        return gain;
    }

    public static void main(String args[]) {
        MaximumScoreFromRemovingSubstrings msrs = new MaximumScoreFromRemovingSubstrings();
        System.out.println(msrs.maximumGain("cdbcbbaaabab", 4, 5));
    }
}
