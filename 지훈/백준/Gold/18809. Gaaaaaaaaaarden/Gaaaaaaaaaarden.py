from itertools import combinations
from collections import deque

N, M, G, R = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(N)]

pos = []
max_flower = 0

# 상하좌우 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(green_s, red_s):
    gq = deque()  # green 큐
    rq = deque()  # red 큐
    flowers = 0  # 꽃 개수 카운트
    state = [[-1] * M for _ in range(N)]  # -1: 배양액 없음, 0: 꽃 핀 상태, 1: green 배양액, 2: red 배양액
    time = [[-1] * M for _ in range(N)]  # 배양액이 도달한 시간 저장

    # Green 시작점 큐에 추가
    for g in green_s:
        gq.append((g[0], g[1]))
        state[g[0]][g[1]] = 1  # Green 배양액
        time[g[0]][g[1]] = 0  # 시간 0으로 시작

    # Red 시작점 큐에 추가
    for r in red_s:
        rq.append((r[0], r[1]))
        state[r[0]][r[1]] = 2  # Red 배양액
        time[r[0]][r[1]] = 0  # 시간 0으로 시작

    while gq or rq:
        # Green 먼저 확산
        gq_len = len(gq)
        for _ in range(gq_len):
            x, y = gq.popleft()

            if state[x][y] == 0:  # 이미 꽃이 핀 곳은 더 확산하지 않음
                continue

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx < N and 0 <= ny < M and maps[nx][ny] != 0:  # 이동 가능하고 호수(0)가 아니면
                    if state[nx][ny] == -1:  # 아직 배양액이 도착하지 않은 곳
                        state[nx][ny] = 1  # Green 배양액 도착
                        time[nx][ny] = time[x][y] + 1  # 시간 증가
                        gq.append((nx, ny))
                    elif state[nx][ny] == 2 and time[nx][ny] == time[x][y] + 1:  # Red와 동시 도착
                        state[nx][ny] = 0  # 꽃이 핀 상태
                        flowers += 1

        # Red 확산
        rq_len = len(rq)
        for _ in range(rq_len):
            x, y = rq.popleft()

            if state[x][y] == 0:  # 이미 꽃이 핀 곳은 더 확산하지 않음
                continue

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx < N and 0 <= ny < M and maps[nx][ny] != 0:
                    if state[nx][ny] == -1:  # 아직 배양액이 도착하지 않은 곳
                        state[nx][ny] = 2  # Red 배양액 도착
                        time[nx][ny] = time[x][y] + 1
                        rq.append((nx, ny))
                    elif state[nx][ny] == 1 and time[nx][ny] == time[x][y] + 1:  # Green과 동시 도착
                        state[nx][ny] = 0  # 꽃이 핀 상태
                        flowers += 1

    return flowers

# 배양액을 뿌릴 수 있는 위치들 찾기
for i in range(N):
    for j in range(M):
        if maps[i][j] == 2:
            pos.append([i, j])

# 가능한 모든 조합을 계산
for comb_pos in combinations(pos, G + R):
    for green_start in combinations(comb_pos, G):
        red_start = [k for k in comb_pos if k not in green_start]
        tmp = bfs(green_start, red_start)
        max_flower = max(max_flower, tmp)

print(max_flower)
