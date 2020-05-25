
public class CheckIfaWordOccursAsaPrefixofAnyWordinaSentence {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        CheckIfaWordOccursAsaPrefixofAnyWordinaSentence ciwoapawis = new CheckIfaWordOccursAsaPrefixofAnyWordinaSentence();
        System.out.println(ciwoapawis.isPrefixOfWord("this problem is an easy problem", "pro"));
    }
}
