
import java.util.Arrays;
import java.util.HashMap;

public class VowelSpellchecker {

    private String createVowelGeneric(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                arr[i] = '*';
            }
        }
        return new String(arr);
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String, String> original = new HashMap();
        HashMap<String, String> cap = new HashMap();
        HashMap<String, String> vowel = new HashMap();

        for (String word : wordlist) {
            if (!original.containsKey(word)) {
                original.put(word, word);
            }

            String lower = word.toLowerCase();
            if (!cap.containsKey(lower)) {
                cap.put(lower, word);
            }

            String vowelgen = createVowelGeneric(word.toLowerCase());
            if (!vowel.containsKey(vowelgen)) {
                vowel.put(vowelgen, word);
            }
        }
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (original.containsKey(queries[i])) {
                res[i] = original.get(queries[i]);

            } else if (cap.containsKey(queries[i].toLowerCase())) {
                res[i] = cap.get(queries[i].toLowerCase());
            } else if (vowel.containsKey(createVowelGeneric(queries[i].toLowerCase()))) {
                res[i] = vowel.get(createVowelGeneric(queries[i].toLowerCase()));
            } else {
                res[i] = "";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        VowelSpellchecker vs = new VowelSpellchecker();
        String[] wordlist = new String[]{"KiTe", "kite", "hare", "Hare"};
        String[] queries = new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        System.out.println(Arrays.toString(vs.spellchecker(wordlist, queries)));
    }
}
