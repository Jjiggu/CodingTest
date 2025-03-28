class Solution {
    
    static int[][] dp;
    
    /**
     * Computes the maximum path sum from the top of the triangle to its base.
     *
     * <p>This method utilizes a dynamic programming approach by initializing a fixed-size DP table.
     * Each element in the table is updated based on the maximum sum obtainable from the adjacent elements
     * in the previous row. The maximum path sum is then determined by checking the final row of the DP table.
     *
     * @param triangle a 2D array representing the triangle of integers
     * @return the maximum path sum from the top to the bottom of the triangle
     */
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
    
    /**
     * Finds and returns the maximum value from the last row of the dynamic programming table.
     *
     * <p>This method iterates over the bottom row of the dp array—whose row index is determined by the
     * height of the triangle represented by the arr array—to identify the maximum path sum from the top
     * to the bottom of the triangle.</p>
     *
     * @param dp the 2D array storing cumulative path sums for each element in the triangle
     * @param arr the original triangle array used to determine the number of rows
     * @return the maximum sum found in the bottom row of the dp array
     */
    public int findMax(int[][] dp, int[][] arr) {
        int maxLen = arr.length - 1;
        int maxNum = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (dp[maxLen][i] > maxNum) maxNum = dp[maxLen][i];
        }
        
        return maxNum;
    }
}