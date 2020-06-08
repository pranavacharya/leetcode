
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int arr[] = new int[amount + 1];
        arr[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                arr[i] += arr[i - c];
            }
        }
        return arr[amount];
    }

    public static void main(String args[]) {
        CoinChange2 cc = new CoinChange2();
        int[] coins = new int[]{1, 2, 5};
        System.out.println(cc.change(5, coins));
    }
}
