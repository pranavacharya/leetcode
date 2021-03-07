
public class SumofBeautyofAllSubstrings {

    public int beautySum(String s) {
        int[][] dpMax = new int[s.length()][s.length()];
        int[][] dpMin = new int[s.length()][s.length()];
        preCalculate(dpMax, dpMin, s);
        int ans = 0;
        for (int l = 1; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int left = i;
                int right = i + l;
                ans += (dpMax[left][right] - dpMin[left][right]);
            }
        }
        return ans;
    }

    private void preCalculate(int[][] dpMax, int[][] dpMin, String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            dpMax[i][i] = 1;
            dpMin[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                int[] maxmin = findMaxMin(freq);
                dpMax[i][j] = maxmin[0];
                dpMin[i][j] = maxmin[1];
            }
            for (int j = i + 1; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']--;
            }
            freq[s.charAt(i) - 'a']--;
        }
    }

    private int[] findMaxMin(int[] freq) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }
            max = Math.max(max, freq[i]);
            min = Math.min(min, freq[i]);
        }
        return new int[]{max, min};
    }

    public static void main(String args[]) {
        SumofBeautyofAllSubstrings sbas = new SumofBeautyofAllSubstrings();
        System.out.println(sbas.beautySum("aabcbaa"));
    }
}
