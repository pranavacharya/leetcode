
public class ReverseWordsinaStringIII {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            sb.append(reverseString(word)).append(" ");
        }
        return sb.toString().trim();
    }

    private String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        ReverseWordsinaStringIII rws = new ReverseWordsinaStringIII();
        System.out.println(rws.reverseWords("Let's take LeetCode contest"));
    }
}
