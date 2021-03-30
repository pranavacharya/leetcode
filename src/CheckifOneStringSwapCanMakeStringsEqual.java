
public class CheckifOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int diff = 0;
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            freq[s1.charAt(i) - 'a']++;
        }
        if (diff > 2) {
            return false;
        }

        for (int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i) - 'a']--;
            if (freq[s2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckifOneStringSwapCanMakeStringsEqual ciossmse
                = new CheckifOneStringSwapCanMakeStringsEqual();
        System.out.println(ciossmse.areAlmostEqual("bank", "kanb"));
    }
}
