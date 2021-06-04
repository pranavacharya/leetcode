
public class AvailableCapturesforRook {

    public int numRookCaptures(char[][] board) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        int count = 0;
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == '.') {
                continue;
            } else if (board[i][y] == 'p') {
                count++;
                break;
            } else {
                break;
            }
        }
        for (int i = x + 1; i < board.length; i++) {
            if (board[i][y] == '.') {
                continue;
            } else if (board[i][y] == 'p') {
                count++;
                break;
            } else {
                break;
            }
        }
        for (int j = y - 1; j >= 0; j--) {
            if (board[x][j] == '.') {
                continue;
            } else if (board[x][j] == 'p') {
                count++;
                break;
            } else {
                break;
            }
        }
        for (int j = y + 1; j < board.length; j++) {
            if (board[x][j] == '.') {
                continue;
            } else if (board[x][j] == 'p') {
                count++;
                break;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AvailableCapturesforRook acfr = new AvailableCapturesforRook();
        char[][] board = new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'},
        {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'},
        {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'},
        {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(acfr.numRookCaptures(board));
    }

}
