
public class DetermineColorofaChessboardSquare {

    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a';
        int y = coordinates.charAt(1) - '0';
        return x % 2 == y % 2;
    }

    public static void main(String[] args) {
        DetermineColorofaChessboardSquare dccbs = new DetermineColorofaChessboardSquare();
        System.out.println(dccbs.squareIsWhite("h3"));
    }
}
