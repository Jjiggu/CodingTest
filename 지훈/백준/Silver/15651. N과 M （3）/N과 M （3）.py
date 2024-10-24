N, M = map(int, input().split())
nums = []
is_used = [False] * (N + 1)

def bfs(num):
    if len(nums) == M:
        print(*nums)
        return

    for i in range(1, N + 1):
        nums.append(i)
        bfs(i + 1)
        nums.pop()

bfs(0)