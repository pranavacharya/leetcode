
public class XOROperationinanArray {

    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ start + (2 * i);
        }
        return ans;
    }

    public static void main(String args[]) {
        XOROperationinanArray xoia = new XOROperationinanArray();
        System.out.println(xoia.xorOperation(5, 0));
    }
}
