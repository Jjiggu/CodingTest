import sys
input=sys.stdin.readline
from collections import deque

dx=[-1,1,0,0]
dy=[0,0,-1,1]
cnt=1

def switch(a,b):
    global cnt

    for a,b in arr[a][b]:
        if light[a][b]:
            light[a][b]=False
            cnt+=1
            for i in range(4):
                na=a+dx[i]
                nb=b+dy[i]
                if 0<=na<n and 0<=nb<n and not visited[na][nb]:
                    queue.append((a,b))
                    visited[a][b]=False
                    break

n,m=map(int,input().split())

visited = [[True] * n for _ in range(n)]
light = [[True] * n for _ in range(n)]
arr = [[[] for _ in range(n)] for _ in range(n)]


for i in range(m):
    a,b,x,y=map(int,input().split())
    arr[a-1][b-1].append((x-1,y-1))

queue = deque([(0, 0)])
visited[0][0]=False
light[0][0]=False

while(queue):
    a,b=queue.popleft()
    switch(a,b)
    for i in range(4):
        na=a+dx[i]
        nb=b+dy[i]
        if 0<=na<n and 0<=nb<n and visited[na][nb] and not light[na][nb]:
            queue.append((na,nb))
            visited[na][nb]=False

print(cnt)