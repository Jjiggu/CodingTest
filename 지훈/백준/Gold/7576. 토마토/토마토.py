from collections import deque

M, N = map(int, input().split())

maps = [list(map(int, input().split())) for _ in range(N)]
queue = deque()

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

day = 0

for i in range(N):
    for j in range(M):
        if maps[i][j] == 1:
            queue.append((i, j))

def bfs():
    while queue:
        x, y = queue.popleft()

        for index in range(4):
            nx = x + dx[index]
            ny = y + dy[index]

            if 0 <= nx < N and 0 <= ny < M:
                if maps[nx][ny] == 0:
                    queue.append((nx, ny))
                    maps[nx][ny] = maps[x][y] + 1

bfs()

for row in maps:
    for tomato in row:
        if tomato == 0:
            print(-1)
            exit(0)

    day = max(day, max(row))

print(day - 1)