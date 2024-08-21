import sys
sys.setrecursionlimit(10**6)
N, M = map(int,input().split())

# N x M 방문 유무 확인 행렬 생성
visited = [[False] * M for _ in range(N)]
# N줄 만큼 입력
graph = [list(map(int, input().split())) for _ in range(N)]
# 상, 하, 좌, 우
dx = [0,0,-1,1]
dy = [1,-1,0,0]

each = 0
result = []

def dfs(x, y):
    global each
    # 범위 벗어나면 중단
    if x < 0 or x >= N or y < 0 or y >= M:
        return False
      
    # 범위 안에 있는데, 방문을 안했고, 값이 1이다면 그림으로 판단!
    if visited[x][y] == False and graph[x][y] == 1:
      # 조건식이 통과되면 그림으로 판단하고, count UP!!
      each += 1
      # 방문으로 표시
      visited[x][y] = True
      
      # 해당 번호부터 재귀로 상,하,좌,우 탐색
      for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        dfs(nx, ny)
        
      return True
    return False

# 열
for x in range(N):
  # 행
  for y in range(M):
    if dfs(x, y) == True:
        result.append(each)
        each = 0

if len(result)==0:
    print(len(result))
    print(0)
else:
    print(len(result))
    print(max(result))