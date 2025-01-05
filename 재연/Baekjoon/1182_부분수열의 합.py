import sys

input=sys.stdin.readline
n, s=map(int,input().split())
numbers=list(map(int,input().split()))

cnt=0
answer=[]

def back(start):
    global cnt
    if sum(answer)==s and len(answer)>0:
        cnt+=1
    for i in range (start,n):
        answer.append(numbers[i])
        back(i+1)
        answer.pop()

back(0)
print(cnt)

# len(answer)>0부분을 빼먹음 구글 서치 통해 해결