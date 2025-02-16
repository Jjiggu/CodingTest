import sys

input=sys.stdin.readline
n,m=map(int,input().split())
lessons=list(map(int,input().split()))

start=max(lessons)
end=sum(lessons)
answer=0

while start<=end:
    mid=(start+end)//2
    
    total=0
    cnt=1
    for lesson in lessons:
        if total+lesson>mid:
            cnt+=1
            total=0
        total+=lesson
    if cnt<=m:
        answer=mid
        end=mid-1
    else:
        start=mid+1
print(answer)