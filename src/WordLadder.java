
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int ans = 1;
        Queue<String> queue = new LinkedList();
        HashSet<String> visited = new HashSet();
        queue.add(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return ans;
                }
                char[] arr = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char c = arr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        arr[i] = j;
                        String tempstr = new String(arr);
                        if (wordList.contains(tempstr) && !visited.contains(tempstr)) {
                            queue.add(tempstr);
                            visited.add(tempstr);
                        }
                    }
                    arr[i] = c;
                }
                size--;
            }
            ans++;
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
