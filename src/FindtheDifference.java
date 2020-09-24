
public class FindtheDifference {

    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {

            freq[t.charAt(i) - 'a']--;
            if (freq[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return '.';
    }

    public static void main(String args[]) {
        FindtheDifference fd = new FindtheDifference();
        System.out.println(fd.findTheDifference("abcd", "abcde"));
    }
}
