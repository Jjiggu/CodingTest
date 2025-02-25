N, M = map(int, input().split())
nums = []

def bfs(num):
    if len(nums) == M:
        print(*nums)
        return

    for i in range(num, N + 1):
        nums.append(i)
        bfs(i)
        nums.pop()

bfs(1)