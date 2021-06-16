
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int ans = 0;
        int mostFreq = 0;
        int[] freq = new int[26];
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            freq[s.charAt(j) - 'A']++;
            mostFreq = Math.max(mostFreq, freq[s.charAt(j) - 'A']);

            int size = j - i + 1;
            int change = size - mostFreq;
            if (change > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement lrcr = new LongestRepeatingCharacterReplacement();
        System.out.println(lrcr.characterReplacement("AABABBA", 1));
    }
}
