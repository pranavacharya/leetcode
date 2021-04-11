
import java.util.Arrays;

public class FindtheWinneroftheCircularGame {

    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        int index = 0;
        while (!isLast(arr)) {
            int count = k - 1;
            int j = index + 1;
            while (count > 0) {
                while (arr[j % n] != 1) {
                    j++;
                }
                count--;
                index = j;
                j++;
            }
            arr[index % n] = 0;
            index++;
            while (arr[index % n] != 1) {
                index++;
            }
            index = index % n;
        }
        return index % n + 1;
    }

    private boolean isLast(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
        }
        return count == 1;
    }

    public static void main(String[] args) {
        FindtheWinneroftheCircularGame ftwcg = new FindtheWinneroftheCircularGame();
        System.out.println(ftwcg.findTheWinner(5, 2));
        System.out.println(ftwcg.findTheWinner(6, 5));
    }
}
