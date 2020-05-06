
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        backtracking(result, new ArrayList(), s);
        return result;
    }

    public void backtracking(List<List<String>> result, ArrayList<String> path, String s) {
        if (s.isEmpty()) {
            result.add(new ArrayList(path));
        } else {
            for (int i = 0; i < s.length(); i++) {
                String letter = s.substring(0, i + 1);
                if (isPalindrome(letter)) {
                    path.add(letter);
                    backtracking(result, path, s.substring(i + 1));
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String a) {
        for (int i = 0; i < a.length() / 2; i++) {
            if (a.charAt(i) != a.charAt(a.length() - i - 1)) {
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
