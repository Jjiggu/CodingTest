import sys

input=sys.stdin.readline
n=int(input())

lines=[]
arr=[]

for i in range(n):
    lines.append(list(map(int,input().split())))

lines.sort(key=lambda x:x[0])

for i in range(n):
    arr.append(lines[i][1])

dp=[1]*501

for i in range(n):
    for j in range(i):
        if arr[i]>arr[j]:
            dp[i]=max(dp[j]+1,dp[i])

print(n-max(dp))