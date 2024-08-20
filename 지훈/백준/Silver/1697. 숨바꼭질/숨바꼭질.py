from collections import deque

N, K = map(int, input().split())
MAX = 100001
dist = [0] * MAX

def bfs(start):
    queue = deque()
    queue.append(start)

    while queue:
        x = queue.popleft()
        if x == K:
            return dist[x]

        for nx in (x - 1, x + 1, x * 2):
            if 0 <= nx < MAX and not dist[nx]:
                dist[nx] = dist[x] + 1
                queue.append(nx)

print(bfs(N))
