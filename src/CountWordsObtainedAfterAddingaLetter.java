
import java.util.Arrays;

public class CountWordsObtainedAfterAddingaLetter {

    public int wordCount(String[] startWords, String[] targetWords) {
        int count = 0;
        for (int i = 0; i < targetWords.length; i++) {
            char[] sorted = targetWords[i].toCharArray();
            Arrays.sort(sorted);
            for (int j = 0; j < startWords.length; j++) {
                char[] startSorted = startWords[j].toCharArray();
                Arrays.sort(startSorted);
                if (sorted.length - startSorted.length != 1) {
                    continue;
                }
                int index = 0;
                int startWordIndex = 0;
                while (startWordIndex < startSorted.length && index < sorted.length) {
                    if (sorted[index] == startSorted[startWordIndex]) {
                        startWordIndex++;
                        index++;
                    } else {
                        index++;
                    }
                }
                if (startWordIndex == startSorted.length) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountWordsObtainedAfterAddingaLetter cwoaal = new CountWordsObtainedAfterAddingaLetter();
//        String[] startWords = new String[]{"ant", "act", "tack"};
//        String[] targetWords = new String[]{"tack", "act", "acti"};
        String[] startWords = new String[]{"uh"};
        String[] targetWords = new String[]{"u", "hur", "k", "b", "u", "yse", "giqoy", "lni", "olqb", "nemc"};
        System.out.println(cwoaal.wordCount(startWords, targetWords));
    }
}

//["uh"]
//["u","hur","k","b","u","yse","giqoy","lni","olqb","nemc"]
