
import java.util.PriorityQueue;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum {

    public int minSumOfLengths(int[] arr, int target) {
        PriorityQueue<int[]> list = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < arr.length) {
            if (sum + arr[end] <= target) {
                sum = sum + arr[end];
                end++;
                if (sum == target) {
                    list.add(new int[]{start, end - 1});
                }
            } else {
                sum = sum - arr[start];
                start++;
            }
        }
        if (list.size() < 2) {
            return -1;
        } else {
            int[] current = list.poll();
            int low = current[0];
            int high = current[1];
            while (!list.isEmpty()) {
                int[] cur = list.poll();
                if (cur[0] > high && cur[0] > low && cur[1] > high && cur[1] > low
                        || cur[0] < high && cur[0] < low && cur[1] < high && cur[1] < low) {
                    return (high - low + 1) + (cur[1] - cur[0] + 1);
                }
            }
            return -1;
        }
    }

    public static void main(String args[]) {
        FindTwoNonoverlappingSubarraysEachWithTargetSum ftnosts = new FindTwoNonoverlappingSubarraysEachWithTargetSum();
//        int[] arr = new int[]{7, 3, 4, 7};
        int[] arr = new int[]{3, 1, 1, 1, 5, 1, 2, 1};
//        int[] arr = new int[]{64, 5, 20, 9, 1, 39};
        System.out.println(ftnosts.minSumOfLengths(arr, 3));
    }
}
