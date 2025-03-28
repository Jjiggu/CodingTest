from collections import deque

N, K = map(int, input().split())
MAX = 100001
dist = [-1] * MAX  # -1로 초기화하여 방문 여부를 체크합니다.

def bfs(start):
    """
    Computes the shortest cost to reach the target position from the given start.
    
    This function performs a breadth-first search on a number line to determine the minimum cost to
    reach the global target position K. It explores three moves from the current position: moving to
    2*x at no additional cost, moving to x-1 with a cost of 1, and moving to x+1 with a cost of 1.
    A global distance array is updated accordingly, and the function returns the cost once K is reached.
    
    Args:
        start: The starting position from which the search begins.
    """
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
