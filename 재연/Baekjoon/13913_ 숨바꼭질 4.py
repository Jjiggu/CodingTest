import sys
from collections import deque

N, K = map(int, input().split())

route = deque()
parent = [-1] * 100001
dist = [0] * 100001 

def bfs(start, target):
    if start >= target:
        return start - target, list(range(start, target - 1, -1))
    
    visited = [False] * 100001
    route.append(start)
    visited[start] = True

    while route:
        x = route.popleft()

        if x == target:
            return dist[x], reconstruct_path(x)

        next_positions = [2 * x, x + 1, x - 1]
        for next_position in next_positions:
            if 0 <= next_position < 100001 and not visited[next_position]:
                visited[next_position] = True
                route.append(next_position)
                dist[next_position] = dist[x] + 1
                parent[next_position] = x 

def reconstruct_path(x):
    path = []
    while x != -1:
        path.append(x)
        x = parent[x]
    path.reverse()
    return path

time, path = bfs(N, K)
print(time)
print(" ".join(map(str, path)))
