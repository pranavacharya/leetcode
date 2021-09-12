
public class ReversePrefixofWord {

    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i));
            if (word.charAt(i) == ch) {
                return sb.reverse().toString() + word.substring(i + 1);
            }
        }
        return word;
    }

    public static void main(String[] args) {
        ReversePrefixofWord rpw = new ReversePrefixofWord();
        System.out.println(rpw.reversePrefix("abcdef", 'd'));
    }
}
