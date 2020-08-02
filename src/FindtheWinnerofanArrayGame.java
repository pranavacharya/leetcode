
public class FindtheWinnerofanArrayGame {

    public int getWinner(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            if (i != 0 && arr[i] > arr[i - 1]) {
                count++;
            }
            boolean flag = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                    if (count >= k) {
                        return arr[i];
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag || count >= k) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        FindtheWinnerofanArrayGame fwag = new FindtheWinnerofanArrayGame();
        int[] arr = new int[]{2, 1, 3, 5, 4, 6, 7};
        System.out.println(fwag.getWinner(arr, 2));
    }
}
