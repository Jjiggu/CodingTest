# 1. M: 세로, N: 가로, K: 직사각형의 개수
# 2. check_lst: 가로, 세로 크기만큼 0으로 채우기
# 3. 직사각형 하나씩 받아서 그 안 채우기
# 4. 채워진 것 bfs 돌려서 영역 개수랑 넓이 구하기

from collections import deque

def bfs(x, y): # 0의 너비 구하기
    queue = deque()
    queue.append((x, y))
    check_lst[x][y] = 1
    w = 1
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]

    while queue:
        a, b = queue.popleft()
        for dir in range(4):
            aa = a + dx[dir]
            bb = b + dy[dir]
            if aa < 0 or aa >= M or bb < 0 or bb >= N:
                continue
            if check_lst[aa][bb] == 0:
                w += 1
                queue.append((aa, bb))
                check_lst[aa][bb] = 1

    return w


M, N, K = map(int, input().split())
check_lst = [[0]*N for _ in range(M)]

for _ in range(K):
    l_x, l_y, r_x, r_y = map(int, input().split())
    for i in range(M): # 세로 y
        for j in range(N): # 가로 x
            if l_x <= j < r_x and l_y <= i < r_y:
                check_lst[i][j] = 1

count = 0
w_lst = []
for i in range(M):
    for j in range(N):
        if check_lst[i][j] == 0:
            count += 1
            w_lst.append(bfs(i, j))

print(count)
w_lst.sort()
print(*w_lst)