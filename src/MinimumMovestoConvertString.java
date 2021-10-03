
public class MinimumMovestoConvertString {

    public int minimumMoves(String s) {
        int moves = 0;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == 'X') {
                moves++;
                i += 3;
            } else {
                i++;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        MinimumMovestoConvertString mmcs = new MinimumMovestoConvertString();
        System.out.println(mmcs.minimumMoves("XXX"));
    }
}
