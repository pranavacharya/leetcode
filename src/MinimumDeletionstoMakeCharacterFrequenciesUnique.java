
import java.util.Arrays;
import java.util.HashSet;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        Arrays.sort(arr);
        int count = 0;
        HashSet<Integer> set = new HashSet();
        for (int i = arr.length - 1; i >= 0;) {
            if (arr[i] == 0) {
                i--;
                continue;
            }
            if (set.contains(arr[i])) {
                arr[i]--;
                count++;
            } else {
                set.add(arr[i]);
                i--;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        MinimumDeletionstoMakeCharacterFrequenciesUnique mdtcfu
                = new MinimumDeletionstoMakeCharacterFrequenciesUnique();
        System.out.println(mdtcfu.minDeletions("bbcebab"));
    }
}
