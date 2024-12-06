from collections import deque

result = []

for _ in range(int(input())):
    R, C = map(int, input().split())

    maps = [list(input().strip()) for _ in range(C)]
    dist1 = [[-1] * R for _ in range(C)]  # 초기값을 -1로 설정 (방문 여부 체크)
    dist2 = [[-1] * R for _ in range(C)]  # 초기값을 -1로 설정 (방문 여부 체크)
    queue1 = deque()
    queue2 = deque()

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    # 불과 지훈의 시작 위치 설정
    for i in range(C):
        for j in range(R):
            if maps[i][j] == "*":
                queue1.append((i, j))
                dist1[i][j] = 0

            if maps[i][j] == "@":
                queue2.append((i, j))
                dist2[i][j] = 0

    # 불의 확산 BFS
    while queue1:
        x, y = queue1.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < C and 0 <= ny < R and dist1[nx][ny] == -1 and maps[nx][ny] != "#":
                dist1[nx][ny] = dist1[x][y] + 1
                queue1.append((nx, ny))


    def bfs(queue2):
        # 지훈의 이동 BFS
        while queue2:
            x, y = queue2.popleft()

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if not (0 <= nx < C and 0 <= ny < R):
                    # 지훈이 벽을 넘어서 나가는 경우
                    return (dist2[x][y] + 1)

                if dist2[nx][ny] == -1 and maps[nx][ny] != "#":
                    if dist1[nx][ny] == -1 or dist1[nx][ny] > dist2[x][y] + 1:
                        dist2[nx][ny] = dist2[x][y] + 1
                        queue2.append((nx, ny))

        return "IMPOSSIBLE"

    result.append(bfs(queue2))

for i in result:
    print(i)
