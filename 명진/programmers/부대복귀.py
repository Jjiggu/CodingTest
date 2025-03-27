from collections import deque


def solution(n, roads, sources, destination):
    graph = [[] for i in range(n+1)]
    for u, v in roads:
        graph[u] += [v]
        graph[v] += [u]
    dist = [-1]*(n+1)

    # BFS
    dist[destination] = 0
    q = deque([destination])
    while q:
        cur = q.popleft()
        for u in graph[cur]:
            if dist[u] != -1:
                continue
            dist[u] = dist[cur] + 1
            q.append(u)
    
    answer = [dist[src] for src in sources]
    return answer