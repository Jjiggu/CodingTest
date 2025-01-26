# n-queen 변형...?
import sys
input=sys.stdin.readline
n=int(input())

visited=[-1]*n
cnt=0

def check(current):
    for i in range(current):
        if abs(current-i)==abs(visited[current]-visited[i]):
            return False
    return True
def back(row):
    global cnt
    
    if row==n:
        cnt+=1
        return
    else:
        for col in range(n):
            visited[row]=col
            if check(row):
                back(row+1)

back(0)
print(cnt)