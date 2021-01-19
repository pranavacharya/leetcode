
import java.util.Arrays;

public class FindMinimumTimetoFinishAllJobs {

    private int minTime = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        for (int i = 0; i < jobs.length / 2; i++) {
            int temp = jobs[i];
            jobs[i] = jobs[jobs.length - 1 - i];
            jobs[jobs.length - 1 - i] = temp;
        }
        int[] workers = new int[k];
        backtracking(jobs, 0, workers);
        return this.minTime;
    }

    private void backtracking(int[] jobs, int i, int[] workers) {
        if (i == jobs.length) {
            this.minTime = Math.min(this.minTime, findMax(workers));
            return;
        }
        for (int j = 0; j < workers.length; j++) {
            if (workers[j] + jobs[i] > this.minTime) {
                continue;
            }
            workers[j] += jobs[i];
            backtracking(jobs, i + 1, workers);
            workers[j] -= jobs[i];
        }
    }

    private int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String args[]) {
        FindMinimumTimetoFinishAllJobs fmtfaj = new FindMinimumTimetoFinishAllJobs();
        int[] jobs = new int[]{12, 13, 14, 17, 25};
        System.out.println(fmtfaj.minimumTimeRequired(jobs, 3));
    }
}

//[12,13,14,17,25]
//3
