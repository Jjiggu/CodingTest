import sys
from collections import deque

N,K=map(int,input().split())

route=deque()

def bfs(start,target):
    if start>=target:
        return start-target
    visited=[False]*100001
    route.append((start,0))
    visited[start]=True

    while route:
        x,time=route.popleft()

        if x==target:
            return time
        
        next_positions=[2*x,x+1,x-1]
        for next_position in next_positions:
            if 0<=next_position<100001 and not visited[next_position]:
                visited[next_position]=True
                route.append((next_position,time+1))


print(bfs(N,K))
