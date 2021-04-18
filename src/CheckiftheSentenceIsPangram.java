
public class CheckiftheSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            freq[sentence.charAt(i) - 'a']++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckiftheSentenceIsPangram csp = new CheckiftheSentenceIsPangram();
        System.out.println(csp.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
