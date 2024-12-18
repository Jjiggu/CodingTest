from collections import deque
import sys

input=sys.stdin.readline

m,n=map(int,input().split())
graph=[]
queue=deque([])


for _ in range(n):
    graph.append(list(map(int,input().split())))

dx=[0,1,0,-1]
dy=[1,0,-1,0]

for i in range(n):
    for j in range(m):
        if graph[i][j]==1:
            queue.append((i,j))

def bfs():
    day=-1
    while queue:
        day+=1
        for _ in range(len(queue)):
            x,y=queue.popleft()
            for i in range(4):
                nx=x+dx[i]
                ny=y+dy[i]

                if 0<=nx<n and 0<=ny<m and graph[nx][ny]==0:
                    graph[nx][ny]=1
                    queue.append((nx,ny))
    for row in graph:
        if 0 in row:
            return -1
    return day
print (bfs())