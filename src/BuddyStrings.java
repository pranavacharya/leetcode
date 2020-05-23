
import java.util.HashSet;

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        HashSet<Character> set = new HashSet();
        if (A.length() != B.length()) {
            return false;
        }
        int[] frequeny = new int[26];
        for (char c : A.toCharArray()) {
            frequeny[c - 'a']++;
        }

        for (char c : B.toCharArray()) {
            frequeny[c - 'a']--;
            if (frequeny[c - 'a'] < 0) {
                return false;
            }
        }
        int count = 2;
        int same = 1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                count--;
                if (count < 0) {
                    return false;
                }
            } else {
                if (set.contains(A.charAt(i))) {
                    same++;
                }
                set.add(A.charAt(i));
            }
        }
        if (count == 0) {
            return true;
        } else {
            if (same > 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String args[]) {
        BuddyStrings bs = new BuddyStrings();
        System.out.println(bs.buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(bs.buddyStrings("ab", "ab"));
        System.out.println(bs.buddyStrings("aa", "aa"));
        System.out.println(bs.buddyStrings("ab", "ba"));
        System.out.println(bs.buddyStrings("abcaa", "abcbb"));
    }
}
