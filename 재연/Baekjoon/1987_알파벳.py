R, C = map(int, input().split())
arr = [list(input()) for _ in range(R)]

ny = [-1, 1, 0, 0]
nx = [0, 0, -1, 1]

def dfs(ci, cj, cnt):
    global ans
    ans = max(ans, cnt)
    for i in range(4):
        dy = ci + ny[i]
        dx = cj + nx[i]
        if 0 <= dy < R and 0 <= dx < C:
            if visited.get(arr[dy][dx], 0) == 0:
                visited[arr[dy][dx]] = 1
                dfs(dy, dx, cnt+1)
                visited[arr[dy][dx]] = 0

ans = 1
visited ={}
visited[arr[0][0]] = 1
dfs(0, 0, 1)
print(ans)