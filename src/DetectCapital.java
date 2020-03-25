
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        boolean noCaps = word.toLowerCase().equals(word);

        boolean firstLetterCap;
        char first = word.charAt(0);
        if (first >= 65 && first <= 90) {
            firstLetterCap = true;
        } else {
            firstLetterCap = false;
        }
        firstLetterCap = firstLetterCap
                && word.substring(1, word.length()).toLowerCase().equals(word.substring(1, word.length()));

        boolean allCaps = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 65 || word.charAt(i) > 90) {
                allCaps = false;
            }
        }
        return allCaps || noCaps || firstLetterCap;
    }

    public static void main(String args[]) {
        DetectCapital dc = new DetectCapital();
        System.out.println(dc.detectCapitalUse("FFFFFFFFFFFFFFFFFFFFf"));
    }
}
