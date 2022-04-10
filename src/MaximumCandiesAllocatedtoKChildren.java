
public class MaximumCandiesAllocatedtoKChildren {

    public int maximumCandies(int[] candies, long k) {
        int high = 10000000;
        int low = 0;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isSatisfied(candies, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isSatisfied(int[] candies, long k, int value) {
        long piles = 0;

        for (int i = 0; i < candies.length; i++) {
            if (value != 0) {
                piles += candies[i] / value;
            }
            if (piles >= k) {
                return true;
            }
        }

        return piles >= k;
    }

    public static void main(String[] args) {
        MaximumCandiesAllocatedtoKChildren mcakc = new MaximumCandiesAllocatedtoKChildren();
        int[] candies = new int[]{2, 5};
        System.out.println(mcakc.maximumCandies(candies, 11));
    }
}

//[4,9,4,7,8,10,3,10,3,9]
//9
