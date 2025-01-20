import sys

input=sys.stdin.readline
n=int(input())
arr=[0]*n

for i in range(n):
    arr[i]=int(input())
    
max_num=max(arr)
dp=[0]*(max_num+1)

dp[1]=1
dp[2]=2
dp[3]=4
for k in range(4,max_num+1):
    dp[k]=(dp[k-1]+dp[k-2]+dp[k-3])%1000000009

for i in range(n):
    print(dp[arr[i]])