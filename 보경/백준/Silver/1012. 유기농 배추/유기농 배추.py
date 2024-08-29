from collections import deque

def bfs(x, y):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    queue = deque([(x, y)])
    while queue:
        a, b = queue.popleft()
        for dir in range(4):
            aa = a + dx[dir]
            bb = b + dy[dir]
            if aa < 0 or aa >= N or bb < 0 or bb >= M:
                continue
            if c_lst[aa][bb] == 1:
                c_lst[aa][bb] = 0
                queue.append((aa, bb))


T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    count = 0
    # M : 가로, N : 세로
    # 배열은 세로부터 적어야 함

    c_lst = [[0] * M for _ in range(N)]

    for i in range(K):
        x, y = map(int, input().split())
        c_lst[y][x] = 1

    for i in range(N):
        for j in range(M):
            if c_lst[i][j] == 1:
                count += 1
                c_lst[i][j] = 1
                bfs(i, j)

    print(count)

