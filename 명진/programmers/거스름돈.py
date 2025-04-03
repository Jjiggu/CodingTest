def solution(n, money):
    dp = [0]*(n+1)
    
    for m in money:
        dp[m] += 1
        for i in range(m, n+1):
            dp[i] += dp[i-m]
            dp[i] %= 1_000_000_007
    return dp[n]