
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ValidPerfectSquare vps = new ValidPerfectSquare();
        System.out.println(vps.isPerfectSquare(12));
    }
}
