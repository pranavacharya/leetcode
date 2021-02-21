
public class BrokenCalculator {

    public int brokenCalc(int X, int Y) {
        if (X == Y) {
            return 0;
        } else if (Y < X) {
            return X - Y;
        } else {
            int count = 0;
            while (Y > X) {
                count++;
                if (Y % 2 == 0) {
                    Y /= 2;
                } else {
                    Y++;
                }
            }
            return count + X - Y;
        }
    }

    public static void main(String args[]) {
        BrokenCalculator bc = new BrokenCalculator();
        System.out.println(bc.brokenCalc(2, 3));
        System.out.println(bc.brokenCalc(3, 10));
        System.out.println(bc.brokenCalc(5, 8));
        System.out.println(bc.brokenCalc(1, 1000000000));
    }
}
