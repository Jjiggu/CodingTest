import sys
from collections import deque

input=sys.stdin.readline

R,C=map(int,input().split())
graph = [list(input().strip()) for _ in range(R)]

dx=[0,1,0,-1]
dy=[1,0,-1,0]

route=deque()
fire=deque()

for i in range(R):
    for j in range(C):
        if graph[i][j]=="J":
            if i == 0 or i == R-1 or j == 0 or j == C-1:
                print(1)
                sys.exit()
            route.append((i,j))
        elif graph[i][j]=="F":
            fire.append((i,j))

def bfs():
    minute=0
    while route:
        minute+=1
        for _ in range(len(fire)):
            p,q=fire.popleft()
            for i in range(4):
                np=p+dx[i]
                nq=q+dy[i]

                if 0<=np<R and 0<=nq<C and graph[np][nq]==".":
                    graph[np][nq]="F"
                    fire.append((np,nq))
        for _ in range(len(route)):
            x,y=route.popleft()
            for i in range(4):
                nx=x+dx[i]
                ny=y+dy[i]

                if 0<=nx<R and 0<=ny<C and graph[nx][ny]==".":
                    if nx==0 or nx==R-1 or ny==0 or ny==C-1:
                        return minute+1
                    graph[nx][ny]="J"
                    route.append((nx,ny))

    return "IMPOSSIBLE"

print(bfs())