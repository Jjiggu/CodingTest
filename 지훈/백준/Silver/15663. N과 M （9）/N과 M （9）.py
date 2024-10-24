N, M = map(int, input().split())
num_list = sorted(list(map(int, input().split())))
nums = []
is_used = [False] * (N + 1)

def dfs(depth):
    if depth == M:
        print(*nums)
        return

    prev_num = -1  # 중복된 값을 스킵하기 위한 변수
    for i in range(1, N + 1):
        if not is_used[i] and num_list[i - 1] != prev_num:
            is_used[i] = True
            nums.append(num_list[i - 1])
            prev_num = num_list[i - 1]  # 이전 숫자를 기록하여 중복 방지
            dfs(depth + 1)
            is_used[i] = False
            nums.pop()

dfs(0)
