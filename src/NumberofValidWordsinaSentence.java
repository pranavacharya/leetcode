
public class NumberofValidWordsinaSentence {

    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].isBlank()) {
                continue;
            }
            int punch = 0;
            int hyphen = 0;
            boolean isHyphen = true;
            boolean isNumber = false;
            for (int j = 0; j < words[i].length(); j++) {
                if (isPunch(words[i], j)) {
                    punch++;
                }
                if (words[i].charAt(j) == '-') {
                    if (j > 0 && j < words[i].length() - 1 && words[i].charAt(j - 1) >= 'a'
                            && words[i].charAt(j - 1) <= 'z' && words[i].charAt(j + 1) >= 'a'
                            && words[i].charAt(j + 1) <= 'z') {
                        hyphen++;
                    } else {
                        isHyphen = false;
                    }
                }

                if (words[i].charAt(j) >= '0' && words[i].charAt(j) <= '9') {
                    isNumber = true;
                }

            }
            if (((punch > 0 && isPunch(words[i], words[i].length() - 1)) || (punch == 0))
                    && hyphen <= 1 && isHyphen && !isNumber && punch < 2) {
                count++;
            }
        }
        return count;
    }

    private boolean isPunch(String word, int i) {
        return word.charAt(i) == '!'
                || word.charAt(i) == '.'
                || word.charAt(i) == ',';
    }

    public static void main(String[] args) {
        NumberofValidWordsinaSentence nvws = new NumberofValidWordsinaSentence();
        System.out.println(nvws.countValidWords("cat and  dog"));
    }
}
