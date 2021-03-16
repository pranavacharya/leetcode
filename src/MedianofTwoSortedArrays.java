
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int mid2 = ((x + y + 1) / 2) - mid;

            int min1 = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1];
            int max1 = mid == x ? Integer.MAX_VALUE : nums1[mid];

            int min2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int max2 = mid2 == y ? Integer.MAX_VALUE : nums2[mid2];

            if (min1 <= max2 && min2 <= max1) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(min1, min2) + (double) Math.min(max1, max2)) / 2.0;
                } else {
                    return (double) Math.max(min1, min2);
                }
            } else if (min1 > max2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays mtsa = new MedianofTwoSortedArrays();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(mtsa.findMedianSortedArrays(nums1, nums2));
    }
}
