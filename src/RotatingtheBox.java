
import java.util.Arrays;

public class RotatingtheBox {

    public char[][] rotateTheBox(char[][] box) {
        for (int i = 0; i < box.length; i++) {
            int last = box[i].length - 1;
            for (int j = box[i].length - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    last = j - 1;
                }
                if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][last] = '#';
                    last--;
                }
            }
        }
        char[][] ans = new char[box[0].length][box.length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][ans[i].length - 1 - j] = box[j][i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RotatingtheBox rtb = new RotatingtheBox();
        char[][] box = new char[][]{{'#', '.', '#'}};
        System.out.println(Arrays.deepToString(rtb.rotateTheBox(box)));
    }
}
