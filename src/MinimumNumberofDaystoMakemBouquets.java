
public class MinimumNumberofDaystoMakemBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int b : bloomDay) {
            min = Math.min(min, b);
            max = Math.max(max, b);
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            int adj = 0;
            int total = 0;
            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] > mid) {
                    adj = 0;
                } else {
                    adj++;
                    if (adj == k) {
                        total++;
                        adj = 0;
                    }
                }
                if (total >= m) {
                    break;
                }
            }
            if (total < m) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public static void main(String args[]) {
        MinimumNumberofDaystoMakemBouquets mndmb = new MinimumNumberofDaystoMakemBouquets();
        int[] bloomDay = new int[]{1, 10, 3, 10, 2};
        System.out.println(mndmb.minDays(bloomDay, 3, 1));
    }
}
