n, m = map(int, input().split())

answer=[]

def btk(start):
    if len(answer)==m:
        print(" ".join(map(str,answer)))
        return
    for i in range(start,n+1):
        if i not in answer:
            answer.append(i)
            btk(i+1)
            answer.pop()
btk(1)

#  from itertools import combinations

# N, M = map(int, input().split())
# numList = [i for i in range(1, N+1)]

# for seq in combinations(numList, M):
#     print(' '.join(map(str, seq)))