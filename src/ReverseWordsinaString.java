
public class ReverseWordsinaString {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            int index = 0;
            while (index < words[i].length() && words[i].charAt(index) == ' ') {
                index++;
            }
            if (index == words[i].length()) {
                continue;
            }
            while (index < words[i].length()) {
                sb.append(words[i].charAt(index++));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String args[]) {
        ReverseWordsinaString rwis = new ReverseWordsinaString();
        System.out.println(rwis.reverseWords("a good   example"));
    }
}
