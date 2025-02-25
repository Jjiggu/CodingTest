from collections import deque

for _ in range(int(input())):
    I = int(input())
    start_x, start_y = list(map(int, input().split()))
    end_x, end_y = list(map(int, input().split()))

    maps = [[0] * (I + 1) for _ in range(I + 1)]
    maps[start_x][start_y] = 1

    def bfs(start_x, start_y, end_x, end_y):
        queue = deque()
        queue.append((start_x, start_y))

        dx = [-1, -1, -2, -2, 1, 1, 2, 2]
        dy = [-2, 2, -1, 1, -2, 2, -1, 1]

        while queue:
            x, y = queue.popleft()

            if x == end_x and y == end_y:
                return maps[x][y] - 1

            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx < I and 0 <= ny < I:
                    if maps[nx][ny] == 0:
                        queue.append((nx, ny))
                        maps[nx][ny] = maps[x][y] + 1


    print(bfs(start_x, start_y, end_x, end_y))
