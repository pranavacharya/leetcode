
public class SentenceSimilarityIII {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        return checkSimilar(sentence1, sentence2) || checkSimilar(sentence2, sentence1);
    }

    private boolean checkSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        if (s2.length > s1.length) {
            return false;
        }

        if (s2.length == 1) {
            return s1[0].equals(s2[0]);
        }

        int i = 0;
        int j = 0;

        while (i < s2.length) {
            if (s1[i].equals(s2[i])) {
                i++;
            } else {
                break;
            }
        }

        while (j < s2.length) {
            if (s1[s1.length - 1 - j].equals(s2[s2.length - 1 - j])) {
                j++;
            } else {
                break;
            }
        }

        return i > s2.length - 1 - j;
    }

    public static void main(String[] args) {
        SentenceSimilarityIII ss = new SentenceSimilarityIII();
        System.out.println(ss.areSentencesSimilar("Game is ON", "Game are ON"));
    }
}
