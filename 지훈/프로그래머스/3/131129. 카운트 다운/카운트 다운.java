import java.util.*;

class Solution {
    public int[] solution(int target) {
        Set<Integer> scores = new HashSet<>();
        int[][] dp = new int[target + 1][2];
        
        for (int i = 1; i <= 20; i++) scores.add(i);
        for (int i = 1; i <= 20; i++) scores.add(i * 2);
        for (int i = 1; i <= 20; i++) scores.add(i * 3);
        scores.add(50);
        
        
        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = 0;
        }
        
        
        for (int i = 1; i <= target; i++) {
            for (int score : scores) {
                if (i - score >= 0 && dp[i - score][0] != Integer.MAX_VALUE) {
                    int prevDarts = dp[i - score][0];
                    int prevSingles = dp[i - score][1];
                    
                    int nowDarts = prevDarts + 1;
                    int nowSingles = prevSingles + (isSingleOrBull(score) ? 1 : 0);
                    
                    if (nowDarts < dp[i][0]) {
                        dp[i][0] = nowDarts;
                        dp[i][1] = nowSingles;
                    }
                    
                    else if (nowDarts == dp[i][0] && nowSingles > dp[i][1]) {
                        dp[i][1] = nowSingles;
                    }
                }
            }
        }
        
        return dp[target];
    }
    
    
    private boolean isSingleOrBull(int score) {
        return (1 <= score && score <= 20) || score == 50;
    }
}