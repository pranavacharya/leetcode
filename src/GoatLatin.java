
public class GoatLatin {

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I'
                || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
            return true;
        }
        return false;
    }

    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        String[] words = S.split(" ");
        int index = 1;
        for (String word : words) {
            if (word.length() > 0) {
                if (isVowel(word.charAt(0))) {
                    sb.append(word);
                } else {
                    char c = word.charAt(0);
                    word = word.substring(1);
                    sb.append(word).append(c);
                }
                sb.append("ma");
                for (int i = 0; i < index; i++) {
                    sb.append("a");
                }
                sb.append(" ");
            }
            index++;
        }
        return sb.toString().trim();
    }

    public static void main(String args[]) {
        GoatLatin gl = new GoatLatin();
        System.out.println(gl.toGoatLatin("I speak Goat Latin"));
    }
}
