
import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList();
        permute(S, 0, list, new char[S.length()]);
        return list;
    }

    private void permute(String s, int index, List<String> result, char[] soFar) {
        if (index == s.length()) {
            result.add(new String(soFar));
            return;
        }
        if (Character.isDigit(s.charAt(index))) {
            soFar[index] = s.charAt(index);
            permute(s, index + 1, result, soFar);
        } else {
            soFar[index] = Character.toLowerCase(s.charAt(index));
            permute(s, index + 1, result, soFar);
            soFar[index] = Character.toUpperCase(s.charAt(index));
            permute(s, index + 1, result, soFar);
        }
    }

    public static void main(String args[]) {
        LetterCasePermutation lcp = new LetterCasePermutation();
        System.out.println(lcp.letterCasePermutation("a1b2"));
        System.out.println(lcp.letterCasePermutation("3z4"));
        System.out.println(lcp.letterCasePermutation("12345"));
    }
}
