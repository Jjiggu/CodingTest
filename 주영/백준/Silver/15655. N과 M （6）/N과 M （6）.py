import sys
input = sys.stdin.readline

N, M = map(int, input().split())
LIST = sorted(list(map(int,input().split())))

total = []

def back(s):
    if len(total) == M:
        print(*total)
        return

    for i in range(s,N):
        total.append(LIST[i])
        back(i+1)
        total.pop()

back(0)