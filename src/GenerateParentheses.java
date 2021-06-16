
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();

        helper("", 0, 0, n, result);

        return result;
    }

    private void helper(String s, int l, int r, int n, List<String> result) {
        if (l == r && r == n) {
            result.add(new String(s));
            return;
        }

        // left bracket
        if (l < n) {
            s = s.concat("(");
            helper(s, l + 1, r, n, result);
            s = s.substring(0, s.length() - 1);
        }

        // right bracket
        if (l > r) {
            s = s.concat(")");
            helper(s, l, r + 1, n, result);
            s = s.substring(0, s.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}
