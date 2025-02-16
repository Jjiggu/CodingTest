import sys

input=sys.stdin.readline
m,n=map(int,input().split())
snacks=list(map(int,input().split()))

start=1
end=max(snacks)

answer=0
while start<=end:
    mid=(start+end)//2
    
    cnt=0
    for snack in snacks:
        if snack<mid:
            continue
        else:
            cnt+=snack//mid
    if cnt>=m:
        start=mid+1
        answer=mid
    else:
        end=mid-1
print(answer)