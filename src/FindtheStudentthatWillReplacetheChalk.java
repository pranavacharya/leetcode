
public class FindtheStudentthatWillReplacetheChalk {

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int[] prefix = new int[n];
        if (chalk[0] > k) {
            return 0;
        }
        prefix[0] = chalk[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + chalk[i];
            if (prefix[i] > k) {
                return i;
            }
        }
        int sum = prefix[n - 1];
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int localMin = ((k - prefix[i]) / sum) + 1;
            if (localMin < min) {
                min = localMin;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FindtheStudentthatWillReplacetheChalk fsrc = new FindtheStudentthatWillReplacetheChalk();
        int[] chalk = new int[]{2, 2, 3};
        System.out.println(fsrc.chalkReplacer(chalk, 1));
    }
}
