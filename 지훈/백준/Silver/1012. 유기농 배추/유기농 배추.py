from collections import deque
answer = []

for _ in range(int(input())):
    M, N, K = map(int, input().split())
    maps = [[0] * (N + 1) for i in range(M + 1)]
    visited = [[False] * (N + 1) for i in range(M + 1)]
    result = []

    for _ in range(K):
        X, Y = map(int, input().split())
        maps[X][Y] = 1

    def bfs(x, y):
        queue = deque()
        queue.append((x, y))

        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]

        cnt = 0

        while queue:
            x, y = queue.popleft()

            for i in  range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx < M and 0 <= ny < N:
                    if maps[nx][ny] == 1 and visited[nx][ny] == False:
                        queue.append((nx, ny))
                        visited[nx][ny] = True
                        cnt += 1
        return cnt


    for i in range(M):
        for j in range(N):
            if maps[i][j] == 1 and visited[i][j] == False:
                visited[i][j] = True
                result.append(bfs(i, j))

    answer.append(len(result))
    
for i in answer:
    print(i)
