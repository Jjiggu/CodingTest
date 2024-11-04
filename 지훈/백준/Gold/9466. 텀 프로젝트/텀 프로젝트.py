def dfs(start):
    stack = []
    cycle_nodes = []
    while True:
        if visited[start]:
            if start in stack:
                cycle_start_index = stack.index(start)
                cycle_nodes = stack[cycle_start_index:]
            break
        stack.append(start)
        visited[start] = True
        start = numbers[start]

    return cycle_nodes

for _ in range(int(input())):
    N = int(input())
    numbers = [0] + list(map(int, input().split()))
    visited = [False] * (N + 1)
    result = set()

    for i in range(1, N + 1):
        if not visited[i]:
            cycle_nodes = dfs(i)
            result.update(cycle_nodes)
    
    print(N - len(result))
