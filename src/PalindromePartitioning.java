
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        helper(0, s, result, new ArrayList());
        return result;
    }

    private void helper(int index, String s, List<List<String>> result, List<String> path) {
        if (index == s.length()) {
            List<String> temp = new ArrayList(path);
            result.add(temp);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s.substring(index, i + 1))) {
                path.add(s.substring(index, i + 1));
                helper(i + 1, s, result, path);
                path.remove(path.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition("abbab"));
    }
}
