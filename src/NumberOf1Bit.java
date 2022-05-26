
public class NumberOf1Bit {

    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if((mask & n) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }

    public static void main(String args[]) {
        NumberOf1Bit no1b = new NumberOf1Bit();
        System.out.println(no1b.hammingWeight(11));
        System.out.println(no1b.hammingWeight(-3));
    }
}
