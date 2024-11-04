from collections import deque

N = int(input())
maps = []
max_num = 0

for _ in range(N):
    x = list(map(int, input().split()))
    maps.append(x)
    now_max = max(x)
    max_num = max(max_num, now_max)


def bfs(start, value):
    queue = deque()
    queue.append((start))

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N:
                if maps[nx][ny] > value and visited[nx][ny] == False:
                    visited[nx][ny] = True
                    queue.append((nx, ny))


result = []

for i in range(max_num):
    visited = [[False] * N for _ in range(N)]
    cnt = 0

    for j in range(N):
        for k in range(N):
            if maps[j][k] > i and visited[j][k] == False:
                visited[j][k] = True
                bfs((j, k), i)
                cnt += 1

    result.append(cnt)

print(max(result))
