
public class CountofMatchesinTournament {

    public int numberOfMatches(int n) {
        int matches = 0;
        while (n > 1) {
            matches += n / 2;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n / 2 + 1;
            }
        }
        return matches;
    }

    public static void main(String args[]) {
        CountofMatchesinTournament cmit = new CountofMatchesinTournament();
        System.out.println(cmit.numberOfMatches(14));
        System.out.println(cmit.numberOfMatches(7));
    }
}
