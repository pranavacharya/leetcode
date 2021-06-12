
public class FindtheStudentthatWillReplacetheChalk {

    public int chalkReplacer(int[] chalk, int k) {
        int index = 0;
        int n = chalk.length;
        while (true) {
            if (chalk[index % n] > k) {
                return index % n;
            }
            k -= chalk[index % n];
            index++;
        }
    }

    public static void main(String[] args) {
        FindtheStudentthatWillReplacetheChalk fsrc = new FindtheStudentthatWillReplacetheChalk();
        int[] chalk = new int[]{3, 4, 1, 2};
        System.out.println(fsrc.chalkReplacer(chalk, 25));
    }
}
