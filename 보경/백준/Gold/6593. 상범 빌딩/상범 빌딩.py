from collections import deque

def escape_building():
    while queue:
        l, r, c = queue.popleft()
        for i in range(6):
            lx = l + dl[i]
            rx = r + dr[i]
            cx = c + dc[i]
            if lx < 0 or lx >= L or rx < 0 or rx >= R or cx < 0 or cx >= C:
                continue
            if map_lst[lx][rx][cx] == '.':
                map_lst[lx][rx][cx] = map_lst[l][r][c] + 1
                queue.append((lx, rx, cx))
            if map_lst[lx][rx][cx] == 'E':
                return "Escaped in {} minute(s).".format(map_lst[l][r][c])
    return 'Trapped!'


L, R, C = map(int, input().split())
E_node = ()
dl = [1, -1, 0, 0, 0, 0]
dr = [0, 0, 1, -1, 0, 0]
dc = [0, 0, 0, 0, 1, -1]
while L != 0 and R != 0 and C != 0:
    map_lst = []
    queue = deque()
    for i in range(L):
        temp = []
        for j in range(R):
            lst = list(input())
            temp.append(lst)
            for k in range(len(lst)):
                if lst[k] == 'S':
                    queue.append((i, j, k))
                    lst[k] = 1
                if lst[k] == 'E':
                    E_node = (i, j, k)

        map_lst.append(temp)
        input()
    print(escape_building())

    L, R, C = map(int, input().split())
