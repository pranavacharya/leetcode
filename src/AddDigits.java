
public class AddDigits {

    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 0) {
                sum += (num % 10);
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String args[]) {
        AddDigits ad = new AddDigits();
        System.out.println(ad.addDigits(38));
    }
}
