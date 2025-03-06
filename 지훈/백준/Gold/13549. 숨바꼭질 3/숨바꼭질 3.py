from collections import deque

N, K = map(int, input().split())
MAX = 100001
dist = [-1] * MAX  # -1로 초기화하여 방문 여부를 체크합니다.

def bfs(start):
    queue = deque([start])
    dist[start] = 0  # 시작점의 거리 초기화

    while queue:
        x = queue.popleft()

        if x == K:
            return dist[x]

        # x * 2의 경우, 거리를 업데이트 하지 않으므로, 최단 거리로 가능한 경우 가장 먼저 방문할 수 있도록 처리합니다.
        if 0 <= x * 2 < MAX and dist[x * 2] == -1:
            dist[x * 2] = dist[x]  # 이동 비용이 0
            queue.append(x * 2)

        # x - 1의 경우, 이동 비용이 1
        if 0 <= x - 1 < MAX and dist[x - 1] == -1:
            dist[x - 1] = dist[x] + 1
            queue.append(x - 1)

        # x + 1의 경우, 이동 비용이 1
        if 0 <= x + 1 < MAX and dist[x + 1] == -1:
            dist[x + 1] = dist[x] + 1
            queue.append(x + 1)

print(bfs(N))
