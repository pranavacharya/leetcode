
public class BinaryNumberwithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >> 1);
        return (n & n + 1) == 0;
    }

    public static void main(String args[]) {
        BinaryNumberwithAlternatingBits bnwab = new BinaryNumberwithAlternatingBits();
        System.out.println(bnwab.hasAlternatingBits(11));
    }
}
