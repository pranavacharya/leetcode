public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        char[] alphabets = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabets[i] = (char) ('a' + i);
        }
        int lastIndex = s.length();
        int index = -1;
        for (int i = 0; i < 26; i++) {
            index = s.indexOf(alphabets[i]);
            if (index >= 0 && index == s.lastIndexOf(alphabets[i])) {
                index = Math.min(index, lastIndex);
                lastIndex = index;
            }
        }
        return lastIndex == s.length() ? -1 : lastIndex;
    }

    public static void main(String ags[]) {
        FirstUniqueCharacter fuc = new FirstUniqueCharacter();
        System.out.println(fuc.firstUniqChar("aaaa"));
    }
}
