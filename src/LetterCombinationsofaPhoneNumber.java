
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    private char[][] map;

    public List<String> letterCombinations(String digits) {
        this.map = new char[10][];
        map[2] = new char[]{'a', 'b', 'c'};
        map[3] = new char[]{'d', 'e', 'f'};
        map[4] = new char[]{'g', 'h', 'i'};
        map[5] = new char[]{'j', 'k', 'l'};
        map[6] = new char[]{'m', 'n', 'o'};
        map[7] = new char[]{'p', 'q', 'r', 's'};
        map[8] = new char[]{'t', 'u', 'v'};
        map[9] = new char[]{'w', 'x', 'y', 'z'};
        List<String> result = new ArrayList();
        helper(result, 0, digits, new StringBuilder());
        return result;
    }

    private void helper(List<String> result, int index, String digits, StringBuilder path) {
        if (index == digits.length()) {
            if (path.length() != 0) {
                result.add(path.toString());
            }
            return;
        }

        for (char c : map[digits.charAt(index) - '0']) {
            path.append(c);
            helper(result, index + 1, digits, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber lcpn = new LetterCombinationsofaPhoneNumber();
        System.out.println(lcpn.letterCombinations("23"));
    }
}
