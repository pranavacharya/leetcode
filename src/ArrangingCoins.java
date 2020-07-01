
public class ArrangingCoins {

    public int arrangeCoins(int n) {
        int count = 0;
        while (n >= count + 1) {
            n = n - (count + 1);
            count++;
        }
        return count;
    }

    public static void main(String args[]) {
        ArrangingCoins ac = new ArrangingCoins();
        System.out.println(ac.arrangeCoins(5));
    }
}
