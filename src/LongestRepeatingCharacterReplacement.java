
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int ans = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int i = 0;
            int j = 0;
            int n = k;
            while (j < s.length()) {
                if (s.charAt(j) == c) {
                    j++;
                } else {
                    if (n > 0) {
                        n--;
                        j++;
                    } else {
                        if (s.charAt(i) != c) {
                            n++;
                        }
                        i++;
                    }
                }
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement lrcr = new LongestRepeatingCharacterReplacement();
        System.out.println(lrcr.characterReplacement("AABABBA", 1));
    }
}
