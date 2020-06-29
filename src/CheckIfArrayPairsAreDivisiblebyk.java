
public class CheckIfArrayPairsAreDivisiblebyk {

    public boolean canArrange(int[] arr, int k) {
        int[] frequency = new int[k];
        for (int a : arr) {
            a = a % k;
            if (a < 0) {
                a = a + k;
            }
            frequency[a]++;
        }

        if (frequency[0] % 2 != 0) {
            return false;
        }

        for (int i = 1; i < k / 2; i++) {
            if (frequency[i] != frequency[k - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        CheckIfArrayPairsAreDivisiblebyk ciapadk = new CheckIfArrayPairsAreDivisiblebyk();
        int[] arr = new int[]{3, 8, 7, 2};
        System.out.println(ciapadk.canArrange(arr, 10));
    }
}
