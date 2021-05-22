
import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList();
        backtracking(new int[10], 0, turnedOn, ans);
        return ans;
    }

    private void backtracking(int[] arr, int index, int left, List<String> ans) {
        if (index == 10) {
            if (left == 0) {
                String time = convertArrToTime(arr);
                if (!time.isEmpty()) {
                    ans.add(time);
                }
            }
            return;
        }
        if (left > 0) {
            left--;
            arr[index] = 1;
            backtracking(arr, index + 1, left, ans);
            arr[index] = 0;
            left++;
        }
        backtracking(arr, index + 1, left, ans);
    }

    private String convertArrToTime(int[] arr) {
        int hour = 0;
        for (int i = 3, index = 0; i >= 0; i--, index++) {
            if (arr[i] == 1) {
                hour += Math.pow(2, index);
            }
        }
        if (hour >= 12) {
            return "";
        }
        int minute = 0;
        for (int i = 9, index = 0; i >= 4; i--, index++) {
            if (arr[i] == 1) {
                minute += Math.pow(2, index);
            }
        }
        if (minute >= 60) {
            return "";
        }
        if (minute < 10) {
            return new String("" + hour + ":0" + minute);
        }
        return new String("" + hour + ":" + minute);
    }

    public static void main(String[] args) {
        BinaryWatch bw = new BinaryWatch();
        System.out.println(bw.readBinaryWatch(1));
    }
}
