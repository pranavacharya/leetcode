
public class PeakIndexinaMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String args[]) {
        PeakIndexinaMountainArray pima = new PeakIndexinaMountainArray();
        int[] arr = new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        System.out.println(pima.peakIndexInMountainArray(arr));
    }
}
