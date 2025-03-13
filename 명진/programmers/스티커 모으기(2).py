
def e(dp): # evaluate
    dp = [0] + dp
    for i in range(2, len(dp)):
        dp[i] = max(dp[i-1], dp[i] + dp[i-2])
    return dp[-1]

def solution(sticker):
    answer = sticker[0]

    answer = max(answer, e(sticker[:-1]), e(sticker[1:]))

    return answer