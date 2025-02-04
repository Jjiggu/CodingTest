import sys

input=sys.stdin.readline

n=int(input())
seq=list(map(int,input().split()))
rev_seq=list(reversed(seq))

dp=[0]*1001

lis_left_dp=[1]*1001
lis_right_dp=[1]*1001

for i in range (n):
    for j in range(i):
        if seq[i]>seq[j]:
            lis_left_dp[i]=max(lis_left_dp[i],lis_left_dp[j]+1)
        if rev_seq[i]>rev_seq[j]:
            lis_right_dp[i]=max(lis_right_dp[i],lis_right_dp[j]+1)

for i in range(n):
    dp[i]=lis_left_dp[i]+lis_right_dp[n-i-1]-1

print(max(dp))

# 넘모 노가다 코드 너낌...?