
public class Numberof1Bits {

    public int hammingWeight(int n) {
        int length = 32;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (((1 << i) | n) == n) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Numberof1Bits nb = new Numberof1Bits();
        System.out.println(nb.hammingWeight(11));
    }
}
