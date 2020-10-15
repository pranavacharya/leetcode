
public class PeakIndexinaMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int maxIndex = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                maxIndex = i;
                max = arr[i];
            }
        }
        return maxIndex;
    }

    public static void main(String args[]) {
        PeakIndexinaMountainArray pima = new PeakIndexinaMountainArray();
        int[] arr = new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        System.out.println(pima.peakIndexInMountainArray(arr));
    }
}
