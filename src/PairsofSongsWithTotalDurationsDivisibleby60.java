
public class PairsofSongsWithTotalDurationsDivisibleby60 {

    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        PairsofSongsWithTotalDurationsDivisibleby60 pswtddb = new PairsofSongsWithTotalDurationsDivisibleby60();
        int[] arr = new int[]{30, 20, 150, 100, 40};
        System.out.println(pswtddb.numPairsDivisibleBy60(arr));
    }
}
