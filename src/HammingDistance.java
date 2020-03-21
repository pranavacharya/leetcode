
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while (res > 0) {
            res &= (res - 1);
            count++;
        }
        return count;
    }

    public static void main(String args[]) {
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(1, 4));
    }
}
