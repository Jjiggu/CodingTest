import java.util.*;

class Solution {
    static int[][] dp;
    static boolean[][] visited;
    static int MOD = 1_000_000_007;
     
    /**
     * Calculates the number of unique paths from the top-left to the bottom-right corner
     * of a grid while avoiding puddle obstacles.
     *
     * <p>The grid is defined by n rows and m columns. This method uses dynamic programming,
     * where each cell's path count is the sum of the paths from the cell above and the cell
     * to the left, computed modulo 1,000,000,007. The puddles array specifies cells to avoid,
     * with each puddle represented as an array containing {column, row} coordinates.
     *
     * @param m number of columns in the grid
     * @param n number of rows in the grid
     * @param puddles 2D array where each sub-array represents the coordinates of a puddle as {column, row}
     * @return the total number of unique paths from the top-left to the bottom-right corner modulo 1,000,000,007
     */
    public int solution(int m, int n, int[][] puddles) {
        
        visited = new boolean[n + 2][m + 2];
        
        for (int[] puddle : puddles) {
            visited[puddle[1]][puddle[0]] = true;
        }
        
        dp = new int[n + 2][m + 2];
        dp[1][1] = 1;
        visited[1][1] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j]) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD; 
                }
            }
        }
        
        return dp[n][m];
            
    }    
}