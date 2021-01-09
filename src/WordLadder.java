
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

    public class Pair {

        String word;
        int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, ArrayList<String>> generic = new HashMap();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String before = word.substring(0, i);
                String after = word.substring(i + 1);
                String newString = before.concat("*").concat(after);
                ArrayList<String> combo = generic.getOrDefault(newString, new ArrayList());
                combo.add(word);
                generic.put(newString, combo);
            }
        }

        HashMap<String, Boolean> visited = new HashMap();
        for (String word : wordList) {
            visited.put(word, false);
        }
        Queue<Pair> bfs = new LinkedList<>();
        bfs.add(new Pair(beginWord, 1));
        visited.put(beginWord, true);
        while (!bfs.isEmpty()) {
            Pair current = bfs.remove();
            String currentWord = current.word;
            int currentLevel = current.level;
            visited.put(currentWord, true);
            for (int i = 0; i < currentWord.length(); i++) {
                String before = currentWord.substring(0, i);
                String after = currentWord.substring(i + 1);
                String newString = before.concat("*").concat(after);
                if (generic.containsKey(newString)) {
                    ArrayList<String> nextList = generic.get(newString);
                    for (String nxt : nextList) {
                        if (nxt.equals(endWord)) {
                            return currentLevel + 1;
                        }
                        if (!visited.get(nxt)) {
                            bfs.add(new Pair(nxt, currentLevel + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        WordLadder wl = new WordLadder();
        List<String> wordList = new ArrayList();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(wl.ladderLength("hit", "cog", wordList));
    }
}
