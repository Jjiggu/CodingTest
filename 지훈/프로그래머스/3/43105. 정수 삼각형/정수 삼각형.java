class Solution {
    
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        dp = new int[501][501];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];   
                }
            }
        }
        
        return findMax(dp, triangle);
    }
    
    public int findMax(int[][] dp, int[][] arr) {
        int maxLen = arr.length - 1;
        int maxNum = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (dp[maxLen][i] > maxNum) maxNum = dp[maxLen][i];
        }
        
        return maxNum;
    }
}