
public class HIndexII {

    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int low = 0;
        int high = citations.length - 1;
        int last = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] >= citations.length - mid) {
                last = citations.length - mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return last;
    }

    public static void main(String args[]) {
        HIndexII hi = new HIndexII();
        int[] citations = new int[]{100};
        System.out.println(hi.hIndex(citations));
    }
}
