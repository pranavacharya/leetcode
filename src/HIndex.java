
public class HIndex {

    public int hIndex(int[] citations) {
        int[] bucket = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= bucket.length - 1) {
                bucket[bucket.length - 1]++;
            } else {
                bucket[citations[i]]++;
            }
        }
        int count = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        HIndex hi = new HIndex();
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(hi.hIndex(citations));
    }
}
