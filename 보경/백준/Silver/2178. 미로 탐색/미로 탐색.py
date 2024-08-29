from collections import deque

n, m = map(int, input().split())

map_lst = []
for i in range(n):
    temp = []
    s = str(input())
    for j in range(m):
        temp.append(int(s[j]))
    map_lst.append(temp)
    # map_lst.append(list(map(int, input().split())))

# n, m = 4, 6
#
# map_lst = [
#     [1, 0, 1, 1, 1, 1],
#     [1, 0, 1, 0, 1, 0],
#     [1, 0, 1, 0, 1, 1],
#     [1, 1, 1, 0, 1, 1]
# ]

# 1. bfs 돌기
# 2. queue에 시작 점 두기
# 3. 시작점 팝하면서 주변에 1 있나 보기 (사방 확인)
# 4. 있으면 그 칸에 전칸 + 1 하기
# 5. 이때, 처음에 check_lst 는 모두 -1로 정하기
# 6. 시작할 때 queue에 시작점 두면서 check_lst = 1로 두기

queue = deque([(0,0)])

dx = [1, 0, 0, -1]
dy = [0, 1, -1, 0]

while queue:
    x, y = queue.popleft()
    for dir in range(4):
        a = x + dx[dir]
        b = y + dy[dir]
        if a < 0 or a >= n or b < 0 or b >= m:
            continue
        if map_lst[a][b] == 1:
            queue.append((a, b))
            map_lst[a][b] = map_lst[x][y] + 1

print(map_lst[n-1][m-1])
