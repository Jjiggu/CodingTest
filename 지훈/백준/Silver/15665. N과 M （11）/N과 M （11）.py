N, M = map(int, input().split())
num_list = sorted(list(map(int, input().split())))  # 입력된 숫자를 정렬
nums = []
is_used = [False] * (N + 1)

def dfs(depth):
    if depth == M:
        print(*nums)
        return

    prev_num = -1  # 중복된 숫자를 방지하기 위한 변수
    for i in range(1, N + 1):
        if i not in is_used and  num_list[i - 1] != prev_num:  # 같은 레벨에서 중복된 숫자 건너뛰기
            nums.append(num_list[i - 1])
            prev_num = num_list[i - 1]  # 현재 숫자를 기록하여 중복 방지
            dfs(depth + 1)  # 다음 깊이로 넘어갈 때, 현재 인덱스 i + 1부터 탐색
            nums.pop()

dfs(0)
