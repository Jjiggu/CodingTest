N, S = map(int, input().split())
arr = list(map(int, input().split()))

nums = []
is_used = [False] * (N + 1)
cnt = 0

def dfs(index, sum_arr):
    global cnt

    if index >= N:
        return
    dfs(index + 1, sum_arr)
    
    sum_arr += arr[index]

    if sum_arr == S:
        cnt += 1

    dfs(index + 1, sum_arr)

    # dfs(index + 1, sum_arr - arr[index])

dfs(0, 0)

print(cnt)
