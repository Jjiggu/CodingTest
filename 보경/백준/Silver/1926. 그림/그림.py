from collections import deque

n, m = map(int, input().split())

map_lst = []
for i in range(n):
    map_lst.append(list(map(int, input().split())))

# n, m = 6, 5
# 
# map_lst = [
#     [1, 1, 0, 1, 1],
#     [0, 1, 1, 0, 0],
#     [0, 0, 0, 0, 0],
#     [1, 0, 1, 1, 1],
#     [0, 0, 1, 1, 1],
#     [0, 0, 1, 1, 1]
# ]

check_lst = [[0] * m for _ in range(n)]


def bfs(a, b):
    # 1. a, b가 1이고 방문하지 않았다는 걸 아는 상태
    # 2. queue를 0으로 세팅, queue가 빌 때까지 while문 돌리기
    # 3. 방문처리는 queue에 넣을 때하기
    queue = deque([(a, b)])
    check_lst[i][j] = 1
    dx = [1, 0, 0, -1]
    dy = [0, 1, -1, 0]
    num = 0

    while queue:
        x, y = queue.popleft()
        num += 1
        for dir in range(4):
            a = x + dx[dir]
            b = y + dy[dir]
            if a < 0 or a >= n or b < 0 or b >= m:
                continue
            if check_lst[a][b] == 1:
                continue
            if map_lst[a][b] == 0:
                continue
            queue.append((a, b))
            check_lst[a][b] = 1

    return num





# 1. 노드 하나씩 for문으로 돈다
# 2. 만약에 1이 나올 경우 그 노드를 중심으로 bfs를 수행한다
# 3. bfs 수행 시 1의 개수를 반환한다
# 4. bfs 수행 할때마다 가장 넓이가 넓은 것을 max로 지정한다

max = 0
count = 0

for i in range(n):
    for j in range(m):
        if map_lst[i][j] == 1 and check_lst[i][j] == 0:
            num = bfs(i, j)
            if num > max:
                max = num
            count += 1

print(count)
print(max)