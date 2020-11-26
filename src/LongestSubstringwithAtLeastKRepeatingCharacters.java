
public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        String ans = "";
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (isValidString(s.substring(i, j), k)) {
                    if (ans.length() < s.subSequence(i, j).length()) {
                        ans = s.substring(i, j);
                    }
                }
            }
        }
        return ans.length();
    }

    private boolean isValidString(String s, int k) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }
            if (freq[i] < k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        LongestSubstringwithAtLeastKRepeatingCharacters lslkrc = new LongestSubstringwithAtLeastKRepeatingCharacters();
        System.out.println(lslkrc.longestSubstring("aaabbb", 3));
    }
}
