import itertools

n, m = map(int, input().split())
nums = list(map(int, input().split()))

count = 0

for i in range(1,n+1):
    array = itertools.combinations(nums, i)

    for x in array:
        if sum(x) == m:
            count += 1
print(count)