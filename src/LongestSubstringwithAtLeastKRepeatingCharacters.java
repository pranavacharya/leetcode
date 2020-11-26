
public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        int ans = 0;
        int unique = findUniqueCharacters(s);
        int[] freq;
        for (int u = 1; u <= unique; u++) {
            freq = new int[26];
            int i = 0;
            int j = 0;
            int uc = 0;
            int ks = 0;
            while (j < s.length()) {
                if (uc <= u) {
                    if (freq[s.charAt(j) - 'a'] == 0) {
                        uc++;
                    }
                    freq[s.charAt(j) - 'a']++;
                    if (freq[s.charAt(j) - 'a'] == k) {
                        ks++;
                    }
                    j++;
                } else {
                    if (freq[s.charAt(i) - 'a'] == k) {
                        ks--;
                    }
                    freq[s.charAt(i) - 'a']--;
                    if (freq[s.charAt(i) - 'a'] == 0) {
                        uc--;
                    }
                    i++;
                }

                if (uc == u && uc == ks) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    private int findUniqueCharacters(String s) {
        int unique = 0;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 0) {
                freq[s.charAt(i) - 'a']++;
                unique++;
            }
        }
        return unique;
    }

    public static void main(String args[]) {
        LongestSubstringwithAtLeastKRepeatingCharacters lslkrc = new LongestSubstringwithAtLeastKRepeatingCharacters();
        System.out.println(lslkrc.longestSubstring("aabb", 2));
    }
}
