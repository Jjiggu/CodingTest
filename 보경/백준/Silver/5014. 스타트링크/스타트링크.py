from collections import deque

F, S, G, U, D = map(int, input().split())

# F: 건물 총 층수, S: 강호가 있는 층, G: 회사가 있는 층, U: 위로 몇층, D: 위로 몇층

queue = deque()
queue.append(S)
ud_lst = [U, (-1) * D]
check_lst = [-1] * int(F+1)
check_lst[S] = 0
result = 'use the stairs'

if S == G:
    result = 0
    queue = deque()

while queue:
    s = queue.popleft()
    for dir in ud_lst:
        s_n = s + dir
        if s_n <= 0 or s_n > F:
            continue
        if check_lst[s_n] == -1:
            queue.append(s_n)
            check_lst[s_n] = check_lst[s] + 1
            if s_n == G:
                queue = deque()
                result = check_lst[s_n]
                break

print(result)