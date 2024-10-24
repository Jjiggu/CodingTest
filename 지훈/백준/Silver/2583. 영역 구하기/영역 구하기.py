from collections import deque

M, N, K = map(int, input().split())
maps = [[0 for _ in range(N)] for _ in range(M)]
visited = [[False] * N for _ in range(M)]
rectangle = [list(map(int, input().split())) for _ in range(K)]
result = []

for r in rectangle:
    x1, y1, x2, y2 = r
    for i in range(y1, y2):
        for j in range(x1, x2):
            maps[i][j] = 1


def bfs(start):
    queue = deque()
    queue.append(start)

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    cnt = 1

    while queue:
        x, y = queue.popleft()

        for index in range(4):
            nx = x + dx[index]
            ny = y + dy[index]

            if 0 <= nx < M and 0 <= ny < N:
                if maps[nx][ny] == 0 and visited[nx][ny] == False:
                    queue.append((nx, ny))
                    visited[nx][ny] = True
                    cnt += 1

    return cnt


for m in range(M):
    for n in range(N):
        if maps[m][n] == 0 and visited[m][n] == False:
            visited[m][n] = True
            dimensions = bfs((m, n))
            result.append(dimensions)

result.sort()
print(len(result))
for i in result:
    print(i, end=' ')