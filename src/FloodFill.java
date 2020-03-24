
import java.util.Arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColour = image[sr][sc];
        if (oldColour == newColor) {
            return image;
        }
        return dfs(image, sr, sc, oldColour, newColor);
    }

    public int[][] dfs(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || j < 0 || i > image.length - 1 || j > image[i].length - 1 || image[i][j] != oldColor) {
            return image;
        } else {
            image[i][j] = newColor;
            image = dfs(image, i, j + 1, oldColor, newColor);
            image = dfs(image, i, j - 1, oldColor, newColor);
            image = dfs(image, i + 1, j, oldColor, newColor);
            image = dfs(image, i - 1, j, oldColor, newColor);
            return image;
        }
    }

    public static void main(String args[]) {
        FloodFill ff = new FloodFill();
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int[][] image = new int[][]{{0, 0, 0}, {0, 1, 1}};
        System.out.println(Arrays.deepToString(ff.floodFill(image, 1, 1, 1)));
    }
}
