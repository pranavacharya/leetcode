
public class MinimumCosttoMergeStones {

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if (n == 1) {
            return 0;
        }
        while (n >= k) {
            n = (n - k + 1);
        }
        if (n != 1) {
            return -1;
        }
        n = stones.length;
        int[] arr = new int[n - k + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + k <= n; i++) {
            int cost = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j < i) {
                    arr[j] = stones[j];
                } else if (j == i) {
                    int sum = 0;
                    for (int l = 0; l < k; l++) {
                        sum += stones[j + l];
                    }
                    cost = sum;
                    arr[j] = sum;
                } else {
                    // j > i
                    arr[j] = stones[j + k - 1];
                }
            }
            min = Math.min(min, cost + mergeStones(arr, k));
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinimumCosttoMergeStones mcms = new MinimumCosttoMergeStones();
        int[] stones = new int[]{3, 2, 4, 1};
        System.out.println(mcms.mergeStones(stones, 2));
    }
}
