from collections import deque

def escape(map_lst):
    # 큐 초기화: (x, y, 벽을 부쉈는지 여부)
    queue = deque([(0, 0, 0)])  # (x, y, wall_broken)
    # 방문 배열 초기화: (N x M x 2) - [벽을 부수지 않은 경우, 벽을 부순 경우]
    visited = [[[False, False] for _ in range(M)] for _ in range(N)]
    visited[0][0][0] = True  # 시작점 방문 처리

    # BFS 탐색
    while queue:
        x, y, wall_broken = queue.popleft()

        # 도착점에 도달하면 현재까지 이동한 칸 수 반환
        if x == N - 1 and y == M - 1:
            return distances[x][y][wall_broken]

        # 상하좌우 탐색
        for i in range(4):
            xn = x + dx[i]
            yn = y + dy[i]

            # 맵 경계 내에 있는지 확인
            if 0 <= xn < N and 0 <= yn < M:
                # 벽이 아닌 곳으로 이동하는 경우
                if map_lst[xn][yn] == 0 and not visited[xn][yn][wall_broken]:
                    visited[xn][yn][wall_broken] = True
                    distances[xn][yn][wall_broken] = distances[x][y][wall_broken] + 1
                    queue.append((xn, yn, wall_broken))

                # 벽이 있는 곳으로 이동하는 경우
                if map_lst[xn][yn] == 1 and wall_broken == 0 and not visited[xn][yn][1]:
                    visited[xn][yn][1] = True
                    distances[xn][yn][1] = distances[x][y][wall_broken] + 1
                    queue.append((xn, yn, 1))

    # 도착점에 도달하지 못한 경우
    return -1

# 입력 받기
N, M = map(int, input().split())
map_lst = [list(map(int, input().strip())) for _ in range(N)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

# 거리 배열 초기화: (N x M x 2) - [벽을 부수지 않은 경우, 벽을 부순 경우]
distances = [[[0, 0] for _ in range(M)] for _ in range(N)]
distances[0][0][0] = 1  # 시작점 (1, 1)은 이미 방문한 것으로 처리 (0,0 인덱스에 위치함)

# 최단 거리 계산
result = escape(map_lst)
print(result)
