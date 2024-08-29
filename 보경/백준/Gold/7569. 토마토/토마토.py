from collections import deque

def find_tomato():
    if only_1 == True:
        return 0

    while queue:
        h, n, m = queue.popleft()
        for i in range(6):
            mx = m + dm[i]
            nx = n + dn[i]
            hx = h + dh[i]
            if mx < 0 or mx >= M or nx < 0 or nx >= N or hx < 0 or hx >= H:
                continue
            if box[hx][nx][mx] == 0:
                box[hx][nx][mx] = box[h][n][m] + 1
                queue.append((hx, nx, mx))

    max_num = 0
    for i in range(H):
        for j in range(N):
            if 0 in box[i][j]:
                return -1
            else:
                if max_num < max(box[i][j]):
                    max_num = max(box[i][j])
    return max_num-1

##############################################################################

M, N, H = map(int, input().split())
queue = deque()
dm = [0, 1, -1, 0, 0, 0]
dn = [0, 0, 0, -1, 1, 0]
dh = [-1, 0, 0, 0, 0, 1]
# visited = [[0]*M for _ in range(N) for _ in range(H)]
# print(visited)

box = []
only_1 = True
for i in range(H):
    temp = []
    for j in range(N):
        lst = list(map(int, input().split()))
        temp.append(lst)
        for k in range(M):  # 가로 방향 반복문
            if lst[k] == 1:
                queue.append((i, j, k))  # 익은 토마토 위치 추가
            elif lst[k] == 0:
                only_1 = False
    box.append(temp)
# box[높이][세로][가로]

print(find_tomato())