
import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        int[] frequency = new int[26];
        for (char c : p.toCharArray()) {
            frequency[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()) {
            if (frequency[s.charAt(right) - 'a'] > 0) {
                count--;
            }
            frequency[s.charAt(right) - 'a']--;
            right++;
            if (count == 0) {
                result.add(left);
            }
            if (right - left == p.length()) {
                if (frequency[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                frequency[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        FindAllAnagramsinaString faais = new FindAllAnagramsinaString();
        System.out.println(faais.findAnagrams("cbaebabacd", "abc"));
        System.out.println(faais.findAnagrams("abab", "ab"));
        System.out.println(faais.findAnagrams("baa", "aa"));
        System.out.println(faais.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }
}
