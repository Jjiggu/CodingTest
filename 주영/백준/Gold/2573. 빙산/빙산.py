from collections import deque
import sys
sys.setrecursionlimit(10**6)

n,k=map(int,input().split())

graph=[list(map(int,input().split())) for _ in range(n)]

ix=[0,0,-1,1]
iy=[1,-1,0,0]



def bfs(x,y):
    q=deque([(x,y)])
    vi[x][y]=True
    while q:
        x1,y1=q.popleft()
        for p in range(4):
            x2=x1+ix[p]
            y2=y1+iy[p]
            if 0<= x2 <n and 0<=y2<k and graph[x2][y2] ==0 and vi[x2][y2]==False:
                graph[x1][y1]-=1
            elif  0<= x2 <n and 0<=y2<k and graph[x2][y2] !=0 and vi[x2][y2]==False:
                q.append((x2,y2))
                vi[x2][y2]=True
        if graph[x1][y1] <0:
            graph[x1][y1]=0


data=[]

for i in range(n):
    for j in range(k):
        if graph[i][j]!=0:
            data.append((i,j))

day=0
while data:
    data2=[]
    vi=[[False for _ in range(k)] for _ in range(n)]

    count=0
    for i,j in data:
        if graph[i][j]!=0 and not vi[i][j]:
            bfs(i,j)
            count+=1
        if graph[i][j]==0:
            data2.append((i,j))


    day+=1


    if count>=2:
        print(day-1)
        break
    data = sorted(list(set(data) - set(data2)))


if count<2:
    print(0)