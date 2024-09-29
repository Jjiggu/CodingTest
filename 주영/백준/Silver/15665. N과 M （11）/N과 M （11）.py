from itertools import product

n, m = map(int, input().split())
a = list(map(int, input().split()))

a.sort()
cmb = list(product(a, repeat=m))
ans = []

for c in cmb:
    ans.append(c)

ans = sorted(list(set(ans)))  #중복 제거 후 정렬

for c in ans:
    for i in c:
        print(i, end=' ')
    print()