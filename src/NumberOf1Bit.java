
public class NumberOf1Bit {

    public int hammingWeight(int n) {
        int weight = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) == mask) {
                weight++;
            }
            mask = mask << 1;
        }
        return weight;
    }

    public static void main(String args[]) {
        NumberOf1Bit no1b = new NumberOf1Bit();
        System.out.println(no1b.hammingWeight(11));
        System.out.println(no1b.hammingWeight(-3));
    }
}
