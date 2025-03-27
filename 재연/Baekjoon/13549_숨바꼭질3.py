import sys
from heapq import heappush,heappop

input=sys.stdin.readline
n,k=map(int,input().split())

inf=1e8

dp=[inf]*100001
q=[]

def dijkstra(n,k):
    if k<=n:
        print(n-k)
        return
    heappush(q,[0,n])
    while q:
        w, n=heappop(q)
        for nx in [n+1,n-1,n*2]:
            if 0<=nx<=100000:
                if nx==n*2 and dp[nx]==inf:
                    dp[nx]=w
                    heappush(q,[w,nx])
                elif dp[nx]==inf:
                    dp[nx]=w+1
                    heappush(q,[w+1,nx])
    print(dp[k])

dijkstra(n,k)