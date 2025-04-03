# 시간초과 코드
from itertools import combinations_with_replacement
def solution(n, money):
    money.sort()
    answer = 0
    for i in range(n//money[0]+1):
        for combi in combinations_with_replacement(money,i):
            if sum(combi)==n:
                answer+=1
                answer%=1000000007
    return answer

# 수정 코드=>DP(쪼갤 수 있는 문제)
def solution(n, money):
    answer = 0
    dp=[0]*(n+1)
    dp[0]=1
    
    for coin in money:
        for i in range(coin,n+1):
            dp[i]+=dp[i-coin]
    answer=dp[n]%1000000007
    return answer

