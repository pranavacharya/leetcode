
import java.util.ArrayList;

public class FindtheWinnerofanArrayGame {

    public int getWinner(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList();
        for (int i : arr) {
            list.add(i);
        }
        int n = k;
        int winner = list.get(0);
        while (n > 0) {
            int first = list.get(0);
            int second = list.get(1);
            if (first > second) {
                winner = first;
                list.add(list.remove(1));
                n--;
            } else {
                winner = second;
                list.add(list.remove(0));
                n = k - 1;
            }
        }
        return winner;
    }

    public static void main(String args[]) {
        FindtheWinnerofanArrayGame fwag = new FindtheWinnerofanArrayGame();
        int[] arr = new int[]{2, 1, 3, 5, 4, 6, 7};
        System.out.println(fwag.getWinner(arr, 2));
    }
}
