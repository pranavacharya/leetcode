
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        char[] ar = p.toCharArray();
        Arrays.sort(ar);
        String sorted = String.valueOf(ar);
        permutation(result, s, "", new boolean[p.length()], sorted);
        return result;
    }

    public void permutation(List<Integer> result, String s, String soFar, boolean[] visited, String p) {
        if (soFar.length() == p.length()) {
            if (s.contains(soFar)) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.substring(i).startsWith(soFar) && !result.contains(i)) {
                        result.add(i);
                    }
                }
            }
        } else {
            for (int i = 0; i < p.length(); i++) {
                if (visited[i] || (i != 0 && p.charAt(i) == p.charAt(i - 1) && !visited[i - 1])) {
                    continue;
                }
                visited[i] = true;
                soFar = soFar.concat("" + p.charAt(i));
                permutation(result, s, new String(soFar), visited, p);
                soFar = soFar.substring(0, soFar.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String args[]) {
        FindAllAnagramsinaString faais = new FindAllAnagramsinaString();
        System.out.println(faais.findAnagrams("cbaebabacd", "abc"));
        System.out.println(faais.findAnagrams("abab", "ab"));
        System.out.println(faais.findAnagrams("baa", "aa"));
        System.out.println(faais.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }
}
