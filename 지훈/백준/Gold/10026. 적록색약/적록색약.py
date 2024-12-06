from collections import deque

N = int(input())
maps = [list((input())) for _ in range(N)]
visited = [[False] * (N + 1) for _ in range(N + 1)]

maps_color = maps
visited_color = [[False] * (N + 1) for _ in range(N + 1)]

result = []

def bfs(start, color):
    queue = deque()
    queue.append(start)

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N:
                if maps[nx][ny] == color and visited[nx][ny] == False:
                    queue.append((nx, ny))
                    visited[nx][ny] = True

def bfs_color(start, color):
    queue = deque()
    queue.append(start)

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N:
                if maps_color[nx][ny] == color and visited_color[nx][ny] == False:
                    queue.append((nx, ny))
                    visited_color[nx][ny] = True

cnt = 0
for i in range(N):
    for j in range(N):
        if maps[i][j] in ("R", "G", "B") and visited[i][j] == False:
            visited[i][j] == True
            bfs((i, j), maps[i][j])
            cnt += 1
result.append(cnt)


for i in range(N):
    for j in range(N):
        if maps_color[i][j] == "G":
            maps_color[i][j] = "R"

cnt = 0
for i in range(N):
    for j in range(N):
        if maps_color[i][j] in ("R", "B") and visited_color[i][j] == False:
            visited_color[i][j] == True
            bfs_color((i, j), maps_color[i][j])
            cnt += 1

result.append(cnt)

print(f"{result[0]} {result[1]}")
