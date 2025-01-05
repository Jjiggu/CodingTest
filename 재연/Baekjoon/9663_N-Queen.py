import sys
input=sys.stdin.readline
n=int(input())

# index가 0부터 시작하므로 -1로 초기화
visited=[-1]*n
cnt=0

def check(current):
    for i in range(current):
        if visited[current]==visited[i] or abs(current-i)==abs(visited[current]-visited[i]):
            return False
    return True
def back(row):
    global cnt
    
    if row==n:
        cnt+=1
    else:
        for col in range(n):
            visited[row]=col
            if check(row):
                back(row+1)

back(0)
print(cnt)

