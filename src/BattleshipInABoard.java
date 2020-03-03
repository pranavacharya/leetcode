
public class BattleshipInABoard {

    public int countBattleships(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(i, j, board);
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[i].length - 1) {
            return;
        }
        if (board[i][j] == 'X') {
            board[i][j] = '.';
            dfs(i + 1, j, board);
            dfs(i, j + 1, board);
        }
    }

    public static void main(String args[]) {
        BattleshipInABoard bib = new BattleshipInABoard();
        char[][] board = new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        System.out.println(bib.countBattleships(board));
    }
}
