
public class SortingtheSentence {

    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] res = new String[words.length];

        for (String word : words) {
            int pos = Character.getNumericValue(word.charAt(word.length() - 1));
            res[pos - 1] = word.substring(0, word.length() - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        SortingtheSentence sos = new SortingtheSentence();
        System.out.println(sos.sortSentence("is2 sentence4 This1 a3"));
    }
}
