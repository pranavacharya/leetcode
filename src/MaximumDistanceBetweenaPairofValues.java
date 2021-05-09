
public class MaximumDistanceBetweenaPairofValues {

    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length) {
            while (j < nums2.length && nums1[i] <= nums2[j]) {
                j++;
            }
            max = Math.max(max, j - i - 1);
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumDistanceBetweenaPairofValues mdbpv = new MaximumDistanceBetweenaPairofValues();
        int[] nums1 = new int[]{55, 30, 5, 4, 2};
        int[] nums2 = new int[]{100, 20, 10, 10, 5};
        System.out.println(mdbpv.maxDistance(nums1, nums2));
    }
}
