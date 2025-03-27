from collections import deque


def BFS(start, graph):
    dist = [-1]*(len(graph)+1)
    q = deque()
    q.append(start)
    dist[start] = 0
    while q:
        cur = q.popleft()
        for n in graph[cur]:
            if (dist[n] == -1):
                dist[n] = dist[cur]+1
                q.append(n)
    return dist

def solution(n, edge):
    answer = 0
    graph = [[] for _ in range(n+1)]
    for u, v in edge:
        graph[u] += [v]
        graph[v] += [u]
    dist = BFS(1, graph)
    answer = dist.count(max(dist))
    return answer