
import java.util.Arrays;

public class ExecutionofAllSuffixInstructionsStayinginaGrid {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ans = new int[s.length()];

        int x = startPos[0];
        int y = startPos[1];
        for (int i = 0; i < s.length(); i++) {
            int xpos = y;
            int ypos = x;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'R') {
                    xpos++;
                } else if (s.charAt(j) == 'L') {
                    xpos--;
                } else if (s.charAt(j) == 'U') {
                    ypos--;
                } else {
                    ypos++;
                }
                if (xpos >= 0 && xpos < n && ypos >= 0 && ypos < n) {
                    ans[i]++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ExecutionofAllSuffixInstructionsStayinginaGrid easisg = new ExecutionofAllSuffixInstructionsStayinginaGrid();
        int[] startPos = new int[]{0, 1};
        System.out.println(Arrays.toString(easisg.executeInstructions(3, startPos, "RRDDLU")));
    }
}
