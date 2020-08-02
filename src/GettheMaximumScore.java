
public class GettheMaximumScore {

    private long mod = 1000000007;

    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        long ans = 0;
        long a = 0;
        long b = 0;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                a += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                b += nums2[j++];
            } else {
                ans += Math.max(a, b);
                ans += nums1[i];
                a = 0;
                b = 0;
                i++;
                j++;
            }
        }
        while (i < n) {
            a += nums1[i++];
        }
        while (j < m) {
            b += nums2[j++];
        }
        ans = ((ans + Math.max(a, b)) % mod);
        return (int) ans;
    }

    public static void main(String args[]) {
        GettheMaximumScore gms = new GettheMaximumScore();
        int[] nums1 = new int[]{1, 3, 5, 7, 9};
        int[] nums2 = new int[]{3, 5, 100};
        System.out.println(gms.maxSum(nums1, nums2));
    }
}
