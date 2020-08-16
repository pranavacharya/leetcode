
public class ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
        int odd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                odd++;
                if (odd == 3) {
                    return true;
                }
            } else {
                odd = 0;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ThreeConsecutiveOdds tco = new ThreeConsecutiveOdds();
        int[] arr = new int[]{2, 6, 4, 1};
        System.out.println(tco.threeConsecutiveOdds(arr));
    }
}
