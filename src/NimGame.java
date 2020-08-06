
public class NimGame {

    public boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String args[]) {
        NimGame ng = new NimGame();
        System.out.println(ng.canWinNim(4));
        System.out.println(ng.canWinNim(5));
        System.out.println(ng.canWinNim(7));
    }
}
