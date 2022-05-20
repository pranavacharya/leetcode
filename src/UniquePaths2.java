

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        
        
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1; 
        
        for(int i = 0; i < obstacleGrid.length; i++) {
            for(int j = 0; j < obstacleGrid[i].length; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                if(obstacleGrid[i][j] == 0) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];    
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String args[]) {
        UniquePaths2 up2 = new UniquePaths2();
        int[][] obstacleGrid = new int[][]{{0}};
        System.out.println(up2.uniquePathsWithObstacles(obstacleGrid));
    }
}
