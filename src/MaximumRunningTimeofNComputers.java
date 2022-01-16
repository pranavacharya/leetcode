
public class MaximumRunningTimeofNComputers {

    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;

        for (int i = 0; i < batteries.length; i++) {
            sum += batteries[i];
        }

        long low = 0;
        long high = sum + 1;
        long ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canFit(mid, batteries, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canFit(long time, int[] batteries, int n) {
        long total = time * n;

        long curr = 0;
        for (int i = 0; i < batteries.length; i++) {
            curr += Math.min(time, batteries[i]);
        }

        return curr >= total;
    }

    public static void main(String[] args) {
        MaximumRunningTimeofNComputers mrtc = new MaximumRunningTimeofNComputers();
        int[] batteries = new int[]{3, 3, 3};
        System.out.println(mrtc.maxRunTime(2, batteries));
    }
}
