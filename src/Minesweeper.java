
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {

    public class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private HashMap<String, Integer> bcount = new HashMap<>();

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        bfs(board, click[0], click[1]);
        return board;
    }

    public void bfs(char[][] board, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        if (board[x][y] == 'E') {
            queue.add(new Point(x, y));
            while (!queue.isEmpty()) {
                Point current = queue.remove();
                int bombCount = countAdjacentMines(board, current.x, current.y);
                if (bombCount == 0) {
                    board[current.x][current.y] = 'B';
                    //right
                    if (current.x + 1 < board.length && board[current.x + 1][current.y] == 'E') {
                        queue.add(new Point(current.x + 1, current.y));
                        board[current.x + 1][current.y] = 'B';
                    }
                    //left
                    if (current.x - 1 >= 0 && board[current.x - 1][current.y] == 'E') {
                        queue.add(new Point(current.x - 1, current.y));
                        board[current.x - 1][current.y] = 'B';
                    }
                    //bottom
                    if (current.y + 1 < board[current.x].length && board[current.x][current.y + 1] == 'E') {
                        queue.add(new Point(current.x, current.y + 1));
                        board[current.x][current.y + 1] = 'B';
                    }
                    //top
                    if (current.y - 1 >= 0 && board[current.x][current.y - 1] == 'E') {
                        queue.add(new Point(current.x, current.y - 1));
                        board[current.x][current.y - 1] = 'B';
                    }
                    //rightbottom
                    if (current.y + 1 < board[current.x].length && current.x + 1 < board.length && board[current.x + 1][current.y + 1] == 'E') {
                        queue.add(new Point(current.x + 1, current.y + 1));
                        board[current.x + 1][current.y + 1] = 'B';
                    }
                    //righttop
                    if (current.y - 1 >= 0 && current.x + 1 < board.length && board[current.x + 1][current.y - 1] == 'E') {
                        queue.add(new Point(current.x + 1, current.y - 1));
                        board[current.x + 1][current.y - 1] = 'B';
                    }
                    //leftbottom
                    if (current.y + 1 < board[current.x].length && current.x - 1 >= 0 && board[current.x - 1][current.y + 1] == 'E') {
                        queue.add(new Point(current.x - 1, current.y + 1));
                        board[current.x - 1][current.y + 1] = 'B';
                    }
                    //lefttop
                    if (current.y - 1 >= 0 && current.x - 1 >= 0 && board[current.x - 1][current.y - 1] == 'E') {
                        queue.add(new Point(current.x - 1, current.y - 1));
                        board[current.x - 1][current.y - 1] = 'B';
                    }
                } else {
                    board[current.x][current.y] = Character.forDigit(bombCount, 10);
                }
            }
        }
    }

    public int countAdjacentMines(char[][] board, int x, int y) {

        if (bcount.containsKey("" + x + "_" + y)) {
            return bcount.get("" + x + "_" + y);
        }
        int count = 0;
        //right
        if (x + 1 < board.length) {
            if (board[x + 1][y] == 'M' || board[x + 1][y] == 'X') {
                count++;
            }
        }
        //left
        if (x - 1 >= 0) {
            if (board[x - 1][y] == 'M' || board[x - 1][y] == 'X') {
                count++;
            }
        }
        //bottom
        if (y + 1 < board[x].length) {
            if (board[x][y + 1] == 'M' || board[x][y + 1] == 'X') {
                count++;
            }
        }
        //top
        if (y - 1 >= 0) {
            if (board[x][y - 1] == 'M' || board[x][y - 1] == 'X') {
                count++;
            }
        }
        //rightbottom
        if (y + 1 < board[x].length && x + 1 < board.length) {
            if (board[x + 1][y + 1] == 'M' || board[x + 1][y + 1] == 'X') {
                count++;
            }
        }
        //righttop
        if (y - 1 >= 0 && x + 1 < board.length) {
            if (board[x + 1][y - 1] == 'M' || board[x + 1][y - 1] == 'X') {
                count++;
            }
        }
        //leftbottom
        if (y + 1 < board[x].length && x - 1 >= 0) {
            if (board[x - 1][y + 1] == 'M' || board[x - 1][y + 1] == 'X') {
                count++;
            }
        }
        //lefttop
        if (y - 1 >= 0 && x - 1 >= 0) {
            if (board[x - 1][y - 1] == 'M' || board[x - 1][y - 1] == 'X') {
                count++;
            }
        }
        bcount.put("" + x + "_" + y, count);
        return count;
    }

    public static void main(String args[]) {
        Minesweeper m = new Minesweeper();
        char[][] board = new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
//        char[][] board = new char[][]{{'B', '1', 'E', '1', 'B'}, {'B', '1', 'M', '1', 'B'},
//        {'B', '1', '1', '1', 'B'}, {'B', 'B', 'B', 'B', 'B'}};
        int[] click = new int[]{3, 0};
        System.out.println(Arrays.deepToString(m.updateBoard(board, click)));
    }
}
