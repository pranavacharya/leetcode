
import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList();
        int[] bSupper = new int[26];
        for (int i = 0; i < B.length; i++) {
            int[] freq = calcFreq(B[i]);
            for (int j = 0; j < freq.length; j++) {
                bSupper[j] = Math.max(bSupper[j], freq[j]);
            }
        }
        for (int i = 0; i < A.length; i++) {
            int[] freq = calcFreq(A[i]);
            if (isSubset(freq, bSupper)) {
                res.add(A[i]);
            }
        }
        return res;
    }

    private boolean isSubset(int[] uni, int[] sub) {
        for (int i = 0; i < uni.length; i++) {
            if (uni[i] < sub[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] calcFreq(String s) {
        int[] freq = new int[26];
        for (int j = 0; j < s.length(); j++) {
            freq[s.charAt(j) - 'a']++;
        }
        return freq;
    }

    public static void main(String[] args) {
        WordSubsets ws = new WordSubsets();
        String[] A = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = new String[]{"e", "o"};
        System.out.println(ws.wordSubsets(A, B));
    }
}
