import sys
sys.setrecursionlimit(1000000)
T = int(input())

def dfs(x):
    global count
    visited[x] = True
    cycle.append(x)

    if visited[student[x]]:
        if student[x] in cycle:
            count -= len(cycle[cycle.index(student[x]):])
    else:
        dfs(student[x])

for _ in range(T):
    N = int(input())
    student = list(map(int, input().split()))
    student.insert(0, 0)
    visited = [False] * (N + 1)
    count = N 

    for i in range(1, N + 1):
        if not visited[i]:
            cycle = []
            dfs(i)

    print(count)
