
public class ExpressiveWords {

    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            int i = 0;
            int j = 0;
            while (i < s.length() && j < word.length()) {
                int count1 = 0;
                int count2 = 0;
                if (s.charAt(i) != word.charAt(j)) {
                    break;
                }
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                    count1++;
                }
                while (j + 1 < word.length() && word.charAt(j) == word.charAt(j + 1)) {
                    j++;
                    count2++;
                }
                if (count1 == count2) {
                    i++;
                    j++;
                } else {
                    if (count2 > count1 || count1 < 2) {
                        break;
                    } else {
                        i++;
                        j++;
                    }
                }
            }
            if (i == s.length() && j == word.length()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ExpressiveWords ew = new ExpressiveWords();
        String[] words = new String[]{"hello", "hi", "helo"};
        System.out.println(ew.expressiveWords("heeellooo", words));
    }
}
