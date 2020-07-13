
public class ReverseBits {
    
    public int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse = reverse << 1;
            if ((n & 1) == 1) {
                reverse++;
            }
            n = n >> 1;
        }
        return reverse;
    }
    
    public static void main(String args[]) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(5));
    }
}
