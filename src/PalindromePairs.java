
import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }

                if (isPalindrome(words, i, j)) {
                    List<Integer> tmp = new ArrayList();
                    tmp.add(i);
                    tmp.add(j);
                    result.add(tmp);
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String[] words, int i, int j) {
        int len = words[i].length() + words[j].length();
        int mid = len / 2;

        int left = len % 2 == 0 ? mid - 1 : mid;
        int right = mid;
        
        while (left >= 0 && right < len) {
            char lc;
            char rc;

            if (left >= words[i].length()) {
                lc = words[j].charAt(left - words[i].length());
            } else {
                lc = words[i].charAt(left);
            }

            if (right < words[i].length()) {
                rc = words[i].charAt(right);
            } else {
                rc = words[j].charAt(right - words[i].length());
            }

            if (lc != rc) {
                return false;
            }

            left--;
            right++;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePairs pp = new PalindromePairs();
        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(pp.palindromePairs(words));
    }
}
