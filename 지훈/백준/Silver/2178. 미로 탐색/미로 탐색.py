from collections import deque

N, M = map(int, input().split())
maps = []

for _ in range(N):
    maps.append(list(map(int, input())))

def bfs(start):
    queue = deque()
    queue.append(start)

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if maps[nx][ny] == 1:
                    queue.append((nx, ny))
                    maps[nx][ny] = maps[x][y] + 1

    return maps[N- 1][M - 1]

print(bfs((0, 0)))