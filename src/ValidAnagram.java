
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] first = new int[26];
        int[] second = new int[26];
        for (char c : s.toCharArray()) {
            first[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            second[c - 'a']++;
        }
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        ValidAnagram va  = new ValidAnagram();
        System.out.println(va.isAnagram("anagram", "nagaram"));
        System.out.println(va.isAnagram("rat", "car"));
    }
}
