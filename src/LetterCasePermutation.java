
import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList();
        permutation(S, 0, "", list);
        return list;
    }

    public void permutation(String s, int index, String soFar, List<String> list) {
        if (index == s.length() && !list.contains(soFar)) {
            list.add(soFar);
        } else {
            char c = s.charAt(index);
            if (Character.isAlphabetic(c)) {
                permutation(s, index + 1, soFar.concat("" + c), list);
                if (Character.isLowerCase(c)) {
                    c = Character.toUpperCase(c);
                    permutation(s, index + 1, soFar.concat("" + c), list);
                } else {
                    c = Character.toLowerCase(c);
                    permutation(s, index + 1, soFar.concat("" + c), list);
                }
            } else {
                permutation(s, index + 1, soFar.concat("" + c), list);
            }
        }
    }

    public static void main(String args[]) {
        LetterCasePermutation lcp = new LetterCasePermutation();
        System.out.println(lcp.letterCasePermutation("a1b2"));
        System.out.println(lcp.letterCasePermutation("3z4"));
        System.out.println(lcp.letterCasePermutation("12345"));
    }
}
