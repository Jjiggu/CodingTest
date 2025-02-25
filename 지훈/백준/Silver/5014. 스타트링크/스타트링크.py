from collections import deque

F, S, G, U, D = map(int, input().split())
MAX = F + 1
dist = [0] * MAX

def bfs(start):
    queue = deque()
    queue.append(start)
    dist[start] = 1

    while queue:
        x = queue.popleft()

        if x == G:
            return dist[x] - 1


        for nx in (x + U, x - D):
            if 0 < nx < MAX and not dist[nx]:
                dist[nx] = dist[x] + 1
                queue.append(nx)

    return "use the stairs"

print(bfs(S))
