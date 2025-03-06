import java.util.*;

class Solution {
    static int[][] dp;
    static boolean[][] visited;
    static int MOD = 1_000_000_007;
     
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