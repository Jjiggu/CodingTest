class Solution {
    static final int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        long[][][] dp = new long[m][n][2];
        dp[0][0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) continue; 

                if (j > 0) {
                    if (cityMap[i][j - 1] == 0) {
                        dp[i][j][0] += (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                    } else if (cityMap[i][j - 1] == 2) {
                        dp[i][j][0] += dp[i][j - 1][0];
                    }
                    dp[i][j][0] %= MOD;
                }

            
                if (i > 0) {
                    if (cityMap[i - 1][j] == 0) {
                        dp[i][j][1] += (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                    } else if (cityMap[i - 1][j] == 2) {
                        dp[i][j][1] += dp[i - 1][j][1];
                    }
                    dp[i][j][1] %= MOD;
                }
            }
        }

        return (int) ((dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD);
    }
}
