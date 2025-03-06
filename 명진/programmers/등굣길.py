def solution(m, n, puddles):
    dp = [[0]*(m+1) for _ in range(n+1)]
    for x, y in puddles:
        dp[y][x] = -1
    dp[1][1] = 1
    for r in range(1, n+1):
        for c in range(1, m+1):
            if dp[r][c] == -1:
                dp[r][c] = 0
                continue
            dp[r][c] += (dp[r][c-1] + dp[r-1][c]) % 1000000007
    
    return dp[-1][-1]