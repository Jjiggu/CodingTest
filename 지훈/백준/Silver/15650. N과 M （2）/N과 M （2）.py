from itertools import combinations

N, M = map(int, input().split())

nums = [i for i in range(1, (N + 1))]

# 1 ~ N 사이 수 M개 뽑기
result = list(combinations(nums, M))

for i in result:
    print(*list(i))