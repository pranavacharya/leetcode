
public class RedistributeCharacterstoMakeAllStringsEqual {

    public boolean makeEqual(String[] words) {
        int[] freq = new int[26];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                freq[word.charAt(j) - 'a']++;
            }
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RedistributeCharacterstoMakeAllStringsEqual rdcmase
                = new RedistributeCharacterstoMakeAllStringsEqual();
        String[] words = new String[]{"abc", "aabc", "bc"};
        System.out.println(rdcmase.makeEqual(words));
    }
}
