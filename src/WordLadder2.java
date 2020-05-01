
import java.util.ArrayList;
import java.util.List;

public class WordLadder2 {

    private int count;

    public WordLadder2() {
        this.count = Integer.MAX_VALUE;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList();
        ArrayList<String> path = new ArrayList();
        path.add(beginWord);
        backtracking(result, wordList, path, beginWord, endWord);
        return result;
    }

    public void backtracking(List<List<String>> result, List<String> wordList,
            ArrayList<String> path, String current, String endString) {
        if (current.equals(endString) && !result.contains(path)) {
            if (path.size() < this.count) {
                result.clear();
                result.add(new ArrayList(path));
                this.count = path.size();
            } else if (path.size() == this.count) {
                result.add(new ArrayList(path));
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
                        backtracking(result, wordList, path, newCurrent, endString);
                        path.remove(path.size() - 1);
                        wordList.add(newCurrent);
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        WordLadder2 wl2 = new WordLadder2();
        List<String> wordList = new ArrayList();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(wl2.findLadders("hit", "cog", wordList));
    }
}
