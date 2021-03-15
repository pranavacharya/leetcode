
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int median = n / 2;
        int[] nums = new int[n];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length && index <= median) {
            if (nums1[i] < nums2[j]) {
                nums[index++] = nums1[i++];
            } else {
                nums[index++] = nums2[j++];
            }
        }
        while (i < nums1.length && index <= median) {
            nums[index++] = nums1[i++];
        }

        while (j < nums2.length && index <= median) {
            nums[index++] = nums2[j++];
        }

        if (n % 2 != 0) {
            return (double) nums[median];
        } else {
            return ((double) nums[median] + (double) nums[median - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays mtsa = new MedianofTwoSortedArrays();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(mtsa.findMedianSortedArrays(nums1, nums2));
    }
}
