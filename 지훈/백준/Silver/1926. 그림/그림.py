from collections import deque

N, M = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
result = []


def bfs(start):
    queue = deque()
    queue.append(start)

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    cnt = 1

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if maps[nx][ny] == 1 and visited[nx][ny] == False:
                    queue.append((nx, ny))
                    visited[nx][ny] = True
                    cnt += 1

    return cnt

for width in range(N):
    for depth in range(M):
        if maps[width][depth] == 1 and visited[width][depth] == False:
            visited[width][depth] = True
            dimensions = bfs((width, depth))
            result.append(dimensions)

if len(result) == 0:
    print(len(result))
    print(0)
else:
    print(len(result))
    print(max(result))