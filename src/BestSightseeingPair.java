
public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {
        int i = 0;
        int max = values[i] + i;
        for (int j = 1; j < values.length; j++) {
            int curr = values[i] + values[j] + i - j;
            max = Math.max(curr, max);

            if (values[i] + i < values[j] + j) {
                i = j;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BestSightseeingPair bsp = new BestSightseeingPair();
        int[] values = new int[]{8, 1, 5, 2, 6};
        System.out.println(bsp.maxScoreSightseeingPair(values));
    }
}
