
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> map = new HashMap();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String combo = word.substring(0, i) + "*" + word.substring(i + 1);
                map.putIfAbsent(combo, new ArrayList());
                map.get(combo).add(word);
            }
        }
        int count = 1;
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        HashSet<String> visited = new HashSet();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return count;
                }
                visited.add(curr);
                for (int i = 0; i < curr.length(); i++) {
                    String combo = curr.substring(0, i) + "*" + curr.substring(i + 1);
                    if (map.containsKey(combo)) {
                        ArrayList<String> neighbours = map.get(combo);
                        for (int j = 0; j < neighbours.size(); j++) {
                            if (!visited.contains(neighbours.get(j))) {
                                queue.add(neighbours.get(j));
                            }
                        }
                    }
                }
                size--;
            }
            count++;
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
