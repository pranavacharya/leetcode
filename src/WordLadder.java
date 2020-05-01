
import java.util.ArrayList;
import java.util.List;

public class WordLadder {

    private int count;

    public WordLadder() {
        this.count = Integer.MAX_VALUE;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ArrayList<String> path = new ArrayList();
        path.add(beginWord);
        backtracking(wordList, path, beginWord, endWord);
        return this.count == Integer.MAX_VALUE ? 0 : this.count;
    }

    public void backtracking(List<String> wordList,
            ArrayList<String> path, String current, String endString) {
        if (current.equals(endString)) {
            if (path.size() < this.count) {
                this.count = path.size();
            }
        } else if (wordList.isEmpty()) {
            return;
        } else {
            for (int i = 0; i < current.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    String before = current.substring(0, i);
                    String after = current.substring(i + 1);
                    String newCurrent = before.concat("" + j).concat(after);
                    if (wordList.contains(newCurrent)) {
                        wordList.remove(newCurrent);
                        path.add(newCurrent);
                        backtracking(wordList, path, newCurrent, endString);
                        path.remove(path.size() - 1);
                        wordList.add(newCurrent);
                    }
                }
            }
        }
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
