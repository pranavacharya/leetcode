
import java.util.Arrays;

public class FindLongestAwesomeSubstring {

    public int longestAwesome(String s) {
        int[] pos = new int[1024];
        Arrays.fill(pos, -1);
        int mask = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            mask ^= (1 << c);
            if (mask == 0 || pos[mask] != -1) {
                ans = Math.max(ans, i - pos[mask]);
            }
            for (int j = 0; j < 10; j++) {
                int newMask = mask;
                newMask ^= (1 << j);
                if (newMask == 0 || pos[newMask] != -1) {
                    ans = Math.max(ans, i - pos[newMask]);
                }
            }
            if (mask != 0 && pos[mask] == -1) {
                pos[mask] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindLongestAwesomeSubstring flas = new FindLongestAwesomeSubstring();
        System.out.println(flas.longestAwesome("3242415"));
    }
}
