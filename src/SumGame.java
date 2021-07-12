
public class SumGame {

    public boolean sumGame(String num) {
        int bal = 0;
        int balq = 0;
        for (int i = 0; i < num.length(); ++i) {
            if (num.charAt(i) == '?') {
                balq += (i < num.length() / 2 ? 1 : -1);
            } else {
                bal += (i < num.length() / 2 ? 1 : -1) * (num.charAt(i) - '0');
            }
        }
        return ((balq % 2 == 1) || (bal + balq * 9 / 2 != 0));
    }

    public static void main(String[] args) {
        SumGame sg = new SumGame();
        System.out.println(sg.sumGame("25??"));
    }
}
