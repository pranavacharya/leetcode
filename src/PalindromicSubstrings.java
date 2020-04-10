
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandFromCenter(s, i);
            count += expandFromCenterEven(s, i);
        }
        return count;
    }

    public int expandFromCenter(String s, int index) {
        int count = 1;
        int i = 1;
        while (index - i >= 0 && index + i < s.length()) {
            if (s.charAt(index - i) == s.charAt(index + i)) {
                count++;
            } else {
                return count;
            }
            i++;
        }
        return count;
    }

    public int expandFromCenterEven(String s, int index) {
        int count = 0;
        int i = 0;
        while (index - 1 - i >= 0 && index + i < s.length()) {
            if (s.charAt(index - 1 - i) == s.charAt(index + i)) {
                count++;
            } else {
                return count;
            }
            i++;
        }
        return count;
    }

    public static void main(String args[]) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        System.out.println(ps.countSubstrings("abc"));
    }
}
