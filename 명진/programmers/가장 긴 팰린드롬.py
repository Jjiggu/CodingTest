def solution(s):
    answer = 1
    lenS = len(s)
    dp = [[False]*lenS for _ in range(lenS)]
    dp[0][0] = True
    for i in range(1, lenS):
        dp[i][i] = True
        if s[i-1]==s[i]:
            answer = 2
            dp[i-1][i] = True
        
    for i in range(3, lenS+1):
        for l in range(lenS-i+1):
            r = l+i-1
            dp[l][r] = s[l]==s[r] and dp[l+1][r-1]
            if dp[l][r]:
                answer = max(answer, i)

    return answer