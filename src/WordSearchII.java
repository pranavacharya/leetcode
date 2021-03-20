
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            if (findWord(board, words[i])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    private boolean findWord(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, "", i, j, 0, new HashSet())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, String soFar, int row, int col, int index, HashSet<String> visited) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || visited.contains(row + " " + col)) {
            return false;
        }

        soFar += board[row][col];
        visited.add(row + " " + col);

        if (word.charAt(index) != soFar.charAt(index)) {
            visited.remove(row + " " + col);
            return false;
        }

        for (int[] dir : dirs) {
            if (dfs(board, word, soFar, row + dir[0], col + dir[1], index + 1, visited)) {
                return true;
            }
        }
        visited.remove(row + " " + col);
        return false;
    }

    public static void main(String[] args) {
        WordSearchII ws2 = new WordSearchII();
//        char[][] board = new char[][]{{'a', 'a'}};
//        String[] words = new String[]{"aaa"};
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(ws2.findWords(board, words));
    }
}
