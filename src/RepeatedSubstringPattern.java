
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.length() % (i + 1) != 0) {
                continue;
            }
            String comp = s.substring(0, i + 1);
            boolean flag = true;
            for (int j = i + 1; j < s.length(); j = j + i + 1) {
                if (!s.subSequence(j, j + i + 1).equals(comp)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();
        System.out.println(rsp.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(rsp.repeatedSubstringPattern("aba"));
        System.out.println(rsp.repeatedSubstringPattern("bb"));
        System.out.println(rsp.repeatedSubstringPattern("ababab"));
        System.out.println(rsp.repeatedSubstringPattern("aabaaba"));
    }
}
