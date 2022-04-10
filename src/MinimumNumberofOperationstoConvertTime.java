
public class MinimumNumberofOperationstoConvertTime {

    public int convertTime(String current, String correct) {
        String[] currTime = current.split(":");

        int curr = Integer.parseInt(currTime[0]) * 60;
        curr += Integer.parseInt(currTime[1]);

        String[] corrTime = correct.split(":");

        int corr = Integer.parseInt(corrTime[0]) * 60;
        corr += Integer.parseInt(corrTime[1]);

        int diff = corr - curr;
        int ans = 0;

        if (diff >= 60) {
            ans += diff / 60;
            diff = diff % 60;
        }

        if (diff >= 15) {
            ans += diff / 15;
            diff = diff % 15;
        }

        if (diff >= 5) {
            ans += diff / 5;
            diff = diff % 5;
        }

        if (diff >= 1) {
            ans += diff / 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumNumberofOperationstoConvertTime mnoct = new MinimumNumberofOperationstoConvertTime();
        System.out.println(mnoct.convertTime("02:30", "04:35"));
    }
}
