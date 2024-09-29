n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))
temp = []

def dfs():
    if len(temp) == m:
        print(*temp)
        return
    for i in range(n):
            temp.append(nums[i])
            dfs()
            temp.pop()

dfs()