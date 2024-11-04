from collections import deque

N = int(input())

maps = [list(map(int, input())) for _ in range(N)]
visited = [[False] * N for _ in range(N + 1)]
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

            if 0 <= nx < N and 0 <= ny < N:
                if maps[nx][ny] == 1 and visited[nx][ny] == False:
                    queue.append((nx, ny))
                    visited[nx][ny] = True
                    cnt += 1

    return cnt


for i in range(N):
    for j in range(N):
        if maps[i][j] == 1 and visited[i][j] == False:
            visited[i][j] = True
            num = bfs((i, j))
            result.append(num)

result.sort()

print(len(result))
for num_home in result:
    print(num_home)
    