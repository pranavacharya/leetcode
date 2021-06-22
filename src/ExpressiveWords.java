
public class ExpressiveWords {

    public int expressiveWords(String s, String[] words) {
        int expressiveWords = 0;

        for (String word : words) {
            // check each word
            int i = 0;
            int j = 0;
            boolean isExpressive = true;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) != word.charAt(j)) {
                    isExpressive = false;
                    break;
                }
                int countS = 1;
                int countW = 1;
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                    countS++;
                }
                while (j + 1 < word.length() && word.charAt(j) == word.charAt(j + 1)) {
                    j++;
                    countW++;
                }

                if (countS != countW) {
                    if (countS < 3 || countW > countS) {
                        isExpressive = false;
                        break;
                    }
                }
                i++;
                j++;
            }
            if (isExpressive && i == s.length() && j == word.length()) {
                expressiveWords++;
            }
        }

        return expressiveWords;
    }

    public static void main(String[] args) {
        ExpressiveWords ew = new ExpressiveWords();
        String[] words = new String[]{"hello", "hi", "helo"};
        System.out.println(ew.expressiveWords("heeellooo", words));
    }
}
