from collections import deque


def solution(board):
    lenR, lenC = len(board), len(board[0])
    INF = int(1e9)
    # 방향, dx, dy
    dxy = ([0, 0, 1], [1, 1, 0], [2, 0, -1], [3, -1, 0])
    costs = [[[INF]*4 for c in range(lenC)] for _ in range(lenR)]

    # direction, r, c, cost
    q = deque([[-1, 0, 0, 0]])
    while q:
        direction, r, c, cost = q.popleft()
        for d, dx, dy in dxy:
            nr, nc = r+dx, c+dy
            if 0 > nr or 0 > nc or nr >= lenR or nc >= lenC or board[nr][nc]:
                continue
            nCost = cost + 100
            if direction != -1 and direction != d:
                nCost += 500
            if costs[nr][nc][d] > nCost:
                q.append([d, nr, nc, nCost])
                costs[nr][nc][d] = nCost

    return min(costs[-1][-1])