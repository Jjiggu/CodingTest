import sys

input = sys.stdin.readline
INF = 1e8 

n, e = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(e):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))
    graph[v].append((u, w))

v_1, v_2 = map(int, input().split())  # 반드시 거쳐야 하는 두 정점

def get_smallest_node(distance, visited):
    min_val = INF
    index = -1
    for i in range(1, n + 1):
        if distance[i] < min_val and not visited[i]:
            min_val = distance[i]
            index = i
    return index

def dijkstra(start):
    visited = [False] * (n + 1)
    distance = [INF] * (n + 1)
    distance[start] = 0

    for _ in range(n):
        now = get_smallest_node(distance, visited)
        if now == -1: 
            break
        visited[now] = True
        for neighbor, weight in graph[now]:
            if distance[now] + weight < distance[neighbor]:
                distance[neighbor] = distance[now] + weight
    return distance

result_1 = dijkstra(1)   
result_v1 = dijkstra(v_1) 
result_v2 = dijkstra(v_2) 

path1 = result_1[v_1] + result_v1[v_2] + result_v2[n]
path2 = result_1[v_2] + result_v2[v_1] + result_v1[n]

result = min(path1, path2)

if result >= INF:
    print(-1)
else:
    print(result)