
import java.util.HashSet;

public class LetterTilePossibilities {

    private int count;
    HashSet<String> set;

    public LetterTilePossibilities() {
        this.count = 0;
        this.set = new HashSet();
    }

    public int numTilePossibilities(String tiles) {
        posibilities(tiles, 0, "");
        return this.count;
    }

    public void posibilities(String rem, int index, String path) {
        if (index == rem.length() && !this.set.contains(path) && !path.isEmpty()) {
            System.out.println(path);
            this.set.add(path);
            this.count++;
            permutations("", path);
        } else {
            for (int i = index; i < rem.length(); i++) {
                path = path.concat("" + rem.charAt(i));
                posibilities(rem, i + 1, path);
                path = path.substring(0, path.length() - 1);
                posibilities(rem, i + 1, path);
            }
        }
    }

    public void permutations(String soFar, String rem) {
        if (rem.length() == 0 && !this.set.contains(soFar)) {
            System.out.println(soFar);
            this.set.add(soFar);
            this.count++;
        } else {
            for (int i = 0; i < rem.length(); i++) {
                String before = rem.substring(0, i);
                String after = rem.substring(i + 1);
                soFar = soFar.concat("" + rem.charAt(i));
                permutations(soFar, before.concat(after));
                soFar = soFar.substring(0, soFar.length() - 1);
            }
        }
    }

    public static void main(String args[]) {
        LetterTilePossibilities ltp = new LetterTilePossibilities();
        System.out.println(ltp.numTilePossibilities("AAB"));
    }
}
