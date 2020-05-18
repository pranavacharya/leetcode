
public class PermutationinString {

    public boolean checkInclusion(String s1, String s2) {
        int[] frequency = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            frequency[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        int count = s1.length();
        while (right < s2.length()) {
            if (frequency[s2.charAt(right) - 'a'] > 0) {
                count--;
            }
            frequency[s2.charAt(right) - 'a']--;
            right++;

            if (count == 0) {
                return true;
            }

            if (right - left == s1.length()) {
                if (frequency[s2.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                frequency[s2.charAt(left) - 'a']++;
                left++;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        PermutationinString ps = new PermutationinString();
        System.out.println(ps.checkInclusion("ab", "eidbaooo"));
        System.out.println(ps.checkInclusion("ab", "eidboaoo"));
    }
}
