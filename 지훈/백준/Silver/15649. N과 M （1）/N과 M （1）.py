from itertools import permutations

N, M = map(int, input().split())

nums = [i for i in range(1, (N + 1))]

# 1 ~ N 사이 수 M개 뽑기
result = list(permutations(nums, M))

for i in result:
    print(*list(i))