
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int substring = 0;
        
        for (int i = 0; i < s.length(); i++) {
            substring += expandFromCenter(s, i, i);
            substring += expandFromCenter(s, i - 1, i);
        }
        
        return substring;
    }
    
    private int expandFromCenter(String s, int i, int j) {
        int count = 0;    
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                count++;
                i--;
                j++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        System.out.println(ps.countSubstrings("abc"));
    }
}
