
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String S) {
        HashMap<Character, Integer> freq = new HashMap();
        for (int i = 0; i < S.length(); i++) {
            freq.put(S.charAt(i), freq.getOrDefault(S.charAt(i), 0) + 1);
            if (S.length() % 2 == 0) {
                if (freq.get(S.charAt(i)) > S.length() / 2) {
                    return "";
                }
            } else {
                if (freq.get(S.charAt(i)) > (S.length() + 1) / 2) {
                    return "";
                }
            }
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> (freq.get(b) - freq.get(a)));
        for (char key : freq.keySet()) {
            queue.add(key);
        }
        char[] ans = new char[S.length()];
        int index = 0;
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            int count = freq.get(curr);
            while (count > 0) {
                ans[index] = curr;
                count--;
                index += 2;
                if (index >= ans.length) {
                    index = 1;
                }
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        ReorganizeString rs = new ReorganizeString();
        System.out.println(rs.reorganizeString("abbabbaaab"));
    }
}
