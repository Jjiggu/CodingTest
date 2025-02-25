from sys import stdin
input = stdin.readline
from collections import deque

dl = [-1, 1, 0, 0, 0, 0]
dr = [0, 0, -1, 1, 0, 0]
dc = [0, 0, 0, 0, -1, 1]

def bfs():
    visited = [[[0] * C for _ in range(R)] for _ in range(L)]
    visited[sl][sr][sc] = 1
    
    queue = deque([(sl, sr, sc)])
    
    while queue:
        l, r, c = queue.popleft()
        for d in range(6):
            nl = l + dl[d]
            nr = r + dr[d]
            nc = c + dc[d]
            # 범위 밖이거나
            if not (0 <= nl < L and 0 <= nr < R and 0 <= nc < C):
                continue
            # 이미 방문했거나 벽이면
            if visited[nl][nr][nc] or B[nl][nr][nc] == "#":
                continue
            # 도착지면 출력 후 리턴
            if B[nl][nr][nc] == "E":
                print(f"Escaped in {visited[l][r][c]} minute(s).")
                return
            # 가능한 다음 위치에 거리 표시하고 큐에 담기
            visited[nl][nr][nc] = visited[l][r][c] + 1
            queue.append((nl, nr, nc))
    
    print("Trapped!")   # 불가능한 경우

while True:
    L, R, C = map(int, input().split())
    if (L, R, C) == (0, 0, 0):
        break
    B = []      # 빌딩 3차원 배열로 표현
    sl, sr, sc = -1, -1, -1     # 시작 좌표
    for l in range(L):
        B.append([list(input().rstrip()) for _ in range(R)])
        for r in range(R):
            for c in range(C):
                if B[l][r][c] == "S":
                    sl, sr, sc = l, r, c
        input()
        
    bfs()