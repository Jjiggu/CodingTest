from collections import deque

N = int(input())

map_lst = []
for i in range(N):
    temp = []
    w = input()
    for j in range(N):
        temp.append(int(w[j]))
    map_lst.append(temp)

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    map_lst[x][y] = 0
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    count = 1

    while queue:
        a, b = queue.popleft()
        for dir in range(4):
            aa = a + dx[dir]
            bb = b + dy[dir]
            if aa < 0 or aa >= N or bb < 0 or bb >= N:
                continue
            if map_lst[aa][bb] == 1:
                count += 1
                map_lst[aa][bb] = 0
                queue.append((aa, bb))

    return count


c = 0
c_lst = []
for i in range(N): # 세로
    for j in range(N): # 가로
        if map_lst[i][j] == 1:
            c += 1
            c_lst.append(bfs(i, j))
c_lst.sort()
print(c)
for cc in c_lst:
    print(cc)