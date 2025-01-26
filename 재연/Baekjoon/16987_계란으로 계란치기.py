n=input()

eggs=[]
answer=0

for _ in range(n):
    a,b=map(int,input().split())
    eggs.append([a,b])

def back(start):
    global cnt
    if start==n:
        cnt=0
        for i in range(n):
            if eggs[i][0]<=0:
                cnt+=1
        answer=max(answer,cnt)
        return cnt

    isAllBroken=True
    if eggs[start][0]<=0:
        back(start+1)
        return
    for i in range(n):
        if i==n:
            continue
        if eggs[i][1]>0:
            isAllBroken=False
            break
    for i in range(n):
        if i==start:
            continue
        if eggs[i][0]<=0:
            continue
        
        eggs[i][0]-=eggs[start][1]
        eggs[start][0]-=eggs[i][1]
        back[i+1]
        eggs[i][0]+=eggs[start][1]
        eggs[start][0]+=eggs[i][1]

back(0)
print(answer)