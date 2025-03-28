class Solution {
    /**
     * Calculates the maximum sum obtainable by selecting non-adjacent stickers in a circular arrangement.
     *
     * <p>If the input array contains a single sticker, its value is returned. Otherwise, the method computes two cases:
     * one considering the selection where the first sticker is included (thus excluding the last sticker) and another
     * where the first sticker is excluded (allowing the last sticker to be selected). The maximum sum from these two scenarios is returned.
     * </p>
     *
     * @param sticker an array of integers representing the value of each sticker
     * @return the maximum sum that can be collected by selecting non-adjacent stickers
     */
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        int[] dp = new int[len];

        if (len == 1) {
            return sticker[0];
        }

        dp[0] = sticker[0];
        dp[1] = dp[0];
        
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }
        
        answer = dp[len - 2];

        dp[0] = 0;
        dp[1] = sticker[1];
        
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }
        
        answer = Math.max(answer, dp[len - 1]);
        
        return answer;
    }
}