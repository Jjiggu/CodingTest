def solution(triangle):
    dp = triangle[::-1]

    for r in range(1, len(dp)):
        for c in range(len(dp[r])):
            dp[r][c] += max(dp[r-1][c], dp[r-1][c+1])
    return dp[-1][-1]