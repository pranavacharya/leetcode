
public class DeleteandEarn {

    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        return backtracking(freq);
    }

    private int backtracking(int[] freq) {
        boolean flag = true;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return 0;
        }
        int cost = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }
            if (i > 0 && i < freq.length - 1) {
                int left = freq[i - 1];
                int right = freq[i + 1];
                int local = freq[i];
                freq[i] = 0;
                freq[i - 1] = 0;
                freq[i + 1] = 0;
                cost = Math.max(cost, i * local + backtracking(freq));
                freq[i - 1] = left;
                freq[i + 1] = right;
                freq[i] = local;
            } else if (i == 0) {
                int right = freq[i + 1];
                int local = freq[i];
                freq[i] = 0;
                freq[i + 1] = 0;
                cost = Math.max(cost, i * local + backtracking(freq));
                freq[i + 1] = right;
                freq[i] = local;
            } else {
                int left = freq[i - 1];
                int local = freq[i];
                freq[i] = 0;
                freq[i - 1] = 0;
                cost = Math.max(cost, i * local + backtracking(freq));
                freq[i - 1] = left;
                freq[i] = local;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        DeleteandEarn de = new DeleteandEarn();
        int[] nums = new int[]{3, 4, 2};
//        int[] nums = new int[]{2, 2, 3, 3, 3, 4};
        System.out.println(de.deleteAndEarn(nums));
    }
}
