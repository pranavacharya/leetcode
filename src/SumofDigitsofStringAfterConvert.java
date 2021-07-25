
public class SumofDigitsofStringAfterConvert {

    public int getLucky(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = (s.charAt(i) - 'a') + 1;
            int local = 0;
            while (num > 0) {
                local += num % 10;
                num /= 10;
            }
            sum += local;
        }
        k--;
        while (k > 0) {
            int num = sum;
            int local = 0;
            while (num > 0) {
                local += num % 10;
                num /= 10;
            }
            sum = local;
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {
        SumofDigitsofStringAfterConvert sdsac = new SumofDigitsofStringAfterConvert();
        System.out.println(sdsac.getLucky("leetcode", 2));
    }
}
