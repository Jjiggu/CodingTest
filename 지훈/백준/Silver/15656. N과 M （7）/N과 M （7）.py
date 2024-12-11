N, M = map(int, input().split())
num_list = sorted(list(map(int, input().split())))
nums = []
is_used = [False] * (N + 1)

def bfs(num):
    if len(nums) == M:
        print(*nums)
        return

    for i in range(1, N + 1):
        if not is_used[i]:
            nums.append(num_list[i - 1])
            bfs(i)
            nums.pop()

bfs(0)