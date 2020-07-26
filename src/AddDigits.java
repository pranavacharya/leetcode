
public class AddDigits {

    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }

    public static void main(String args[]) {
        AddDigits ad = new AddDigits();
        System.out.println(ad.addDigits(38));
    }
}
