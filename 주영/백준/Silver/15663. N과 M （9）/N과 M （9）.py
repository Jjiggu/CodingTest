import sys
input = sys.stdin.readline

def tracking(k):
    if(k == m):  # 종료 조건
        for i in range(m):
            print(answer[i], end=' ')
        print()
        return

    temp = 0 # 같은지 확인
    for i in range(n):
        if not checked[i] and temp != arr[i]:
            answer[k] = arr[i]
            checked[i] = True
            temp = arr[i]
            tracking(k+1) # 리턴하면 여기로 다시
            checked[i] = False

n, m = map(int, input().split()) # n까지의 수, m:수열개수
checked = [False]*n
arr = list(map(int, input().split()))
arr.sort()
answer = [-1]*10

tracking(0)