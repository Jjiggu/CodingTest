from collections import deque

T = int(input())

for _ in range(T):
    I = int(input())
    start_x, start_y = map(int, input().split())
    end_x, end_y = map(int, input().split())

    check_lst = [[0] * I for _ in range(I)]
    queue = deque([])
    queue.append((start_x, start_y))
    dx = [-2, -1, 1, 2, 2, 1, -1, -2]
    dy = [1, 2, 2, 1, -1, -2, -2, -1]

    if start_x == end_x and start_y == end_y:
        print(0)
        queue = deque([])

    while queue:
        x, y = queue.popleft()
        for dir in range(8):
            a = x + dx[dir]
            b = y + dy[dir]
            if a < 0 or a >= I or b < 0 or b >= I:
                continue
            if a == end_x and b == end_y:
                queue = deque()
                print(check_lst[x][y]+1)
                break
            if check_lst[a][b] == 0:
                queue.append((a, b))
                check_lst[a][b] = check_lst[x][y] + 1