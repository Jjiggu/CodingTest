import sys
def solution(matrix_sizes):
    answer = 0
    N=len(matrix_sizes)
    dp=[[0 for _ in range(N)]for _ in range(N)]
    
    for dist in range(1,N):
        for start in range(N-dist):
            a=start
            b=start+dist
            dp[a][b]=sys.maxsize
            for i in range(a,b):
                middle_product=matrix_sizes[a][0]*matrix_sizes[i][1]*matrix_sizes[b][1]
                dp[a][b]=min(dp[a][b],dp[a][i]+middle_product+dp[i+1][b])
    answer=dp[0][-1]
    return answer