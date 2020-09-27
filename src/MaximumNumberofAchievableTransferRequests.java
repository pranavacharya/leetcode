
public class MaximumNumberofAchievableTransferRequests {

    private int max = 0;

    public int maximumRequests(int n, int[][] requests) {
        backtracking(requests, 0, new int[n], 0);
        return this.max;
    }

    private void backtracking(int[][] requests, int index, int[] degree, int count) {
        if (index == requests.length) {
            boolean flag = true;
            for (int i = 0; i < degree.length; i++) {
                if (degree[i] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                max = Math.max(max, count);
            }
        } else {
            degree[requests[index][0]]--;
            degree[requests[index][1]]++;
            backtracking(requests, index + 1, degree, count + 1);
            degree[requests[index][0]]++;
            degree[requests[index][1]]--;
            backtracking(requests, index + 1, degree, count);
        }
    }

    public static void main(String args[]) {
        MaximumNumberofAchievableTransferRequests mnatrr = new MaximumNumberofAchievableTransferRequests();
        int[][] requests = new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}};
        System.out.println(mnatrr.maximumRequests(5, requests));
    }
}
