
public class CountSubstringsThatDifferbyOneCharacter {

    public int countSubstrings(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                int window = j - i;
                String first = s.substring(i, j);
                for (int k = 0; k <= t.length() - window; k++) {
                    if (isDiffOne(first, t.substring(k, k + window))) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isDiffOne(String a, String b) {
        int diffs = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffs++;
            }
        }
        return diffs == 1;
    }

    public static void main(String args[]) {
        CountSubstringsThatDifferbyOneCharacter cstdoc = new CountSubstringsThatDifferbyOneCharacter();
        System.out.println(cstdoc.countSubstrings("aba", "baba"));
        System.out.println(cstdoc.countSubstrings("abe", "bbc"));
        System.out.println(cstdoc.countSubstrings("ab", "bb"));
    }
}
