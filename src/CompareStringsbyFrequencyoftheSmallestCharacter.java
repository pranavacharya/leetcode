
import java.util.Arrays;

public class CompareStringsbyFrequencyoftheSmallestCharacter {

    public int countSmallestLetterFrequency(String s) {
        int[] alpha = new int[26];
        for (char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }
        for (int i : alpha) {
            if (i > 0) {
                return i;
            }
        }
        return 0;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsFrequency = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsFrequency[i] = countSmallestLetterFrequency(words[i]);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int qf = countSmallestLetterFrequency(queries[i]);
            for (int j = 0; j < wordsFrequency.length; j++) {
                if (qf < wordsFrequency[j]) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        CompareStringsbyFrequencyoftheSmallestCharacter csfsc = new CompareStringsbyFrequencyoftheSmallestCharacter();
        String[] queries = new String[]{"bbb", "cc"};
        String[] words = new String[]{"a", "aa", "aaa", "aaaa"};
        System.out.println(Arrays.toString(csfsc.numSmallerByFrequency(queries, words)));
    }
}
