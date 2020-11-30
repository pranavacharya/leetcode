
public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int local = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                local += accounts[i][j];
            }
            max = Math.max(max, local);
        }
        return max;
    }

    public static void main(String args[]) {
        RichestCustomerWealth rcw = new RichestCustomerWealth();
        int[][] accounts = new int[][]{{1, 2, 3}, {3, 2, 1}};
        System.out.println(rcw.maximumWealth(accounts));
    }
}
