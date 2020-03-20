
import java.util.ArrayList;
import java.util.List;

public class SubstringwithConcatenationofAllWords {

    private List<String> permutations = new ArrayList<>();

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> wordlist = new ArrayList<>();
        for (String word : words) {
            wordlist.add(word);
        }
        permute("", wordlist);
        List<Integer> result = new ArrayList<>();
        int lensub = words.length * words[0].length();
        for (int i = 0; i <= s.length() - lensub; i++) {
            if (matchString(s.substring(i, i + lensub))) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean matchString(String S) {
        return this.permutations.contains(S);
    }

    public void permute(String soFar, ArrayList<String> words) {
        if (words.isEmpty()) {
            this.permutations.add(soFar);
        } else {
            for (int i = 0; i < words.size(); i++) {
                String left = soFar;
                left = left.concat(words.get(i));
                ArrayList right = new ArrayList(words);
                right.remove(i);
                permute(left, right);
            }
        }
    }

    public static void main(String args[]) {
        SubstringwithConcatenationofAllWords swcoaw = new SubstringwithConcatenationofAllWords();
        String[] words = new String[]{"foo", "bar"};
        System.out.println(swcoaw.findSubstring("barfoothefoobarman", words));
    }
}
