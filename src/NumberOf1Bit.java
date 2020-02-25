
public class NumberOf1Bit {

    public int hammingWeight(int n) {
        String input = Integer.toBinaryString(n);
        int count = 0;
        for(char i: input.toCharArray()){
            if(i == '1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        NumberOf1Bit no1b = new NumberOf1Bit();
        System.out.println(no1b.hammingWeight(11));
    }
}
