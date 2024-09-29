import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

answer = [0]*m

def back(k, idx):
    if k == m:
        for i in range(m):
            print(answer[i], end=' ')
        print()
        return

    temp = 0
    for i in range(idx, n):
        if temp != arr[i]:
            answer[k] = arr[i]
            temp = arr[i]
            back(k+1, i)

back(0, 0)
