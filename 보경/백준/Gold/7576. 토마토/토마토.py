from collections import deque

n, m = map(int, input().split())

map_lst = []
for i in range(m):
    map_lst.append(list(map(int, input().split())))

# 1. 토마토가 며칠이 지나면 익게 되는지를 출력
# 2. for문 돌면서 1인 x, y 좌표 queue에 넣기
# 3. 넣고 시작점과의 거리 구하기
# 4. 마지막에 check_lst의 max값 출력하면 됨

queue = deque([])
dx = [1, 0, 0, -1]
dy = [0, -1, 1, 0]

for i in range(n):
    for j in range(m):
        if map_lst[j][i] == 1:
            queue.append((j, i))

while queue:
    x, y = queue.popleft()
    for dir in range(4):
        a = x + dx[dir]
        b = y + dy[dir]
        if a < 0 or a >= m or b < 0 or b >= n:
            continue
        if map_lst[a][b] == 0:
            queue.append((a, b))
            map_lst[a][b] = map_lst[x][y] + 1

new_map_lst = sum(map_lst, [])
if 0 in new_map_lst:
    print(-1)
else:
    print(max(new_map_lst)-1)