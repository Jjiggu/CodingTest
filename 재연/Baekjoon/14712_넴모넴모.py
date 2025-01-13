n,m=map(int,input().split())
board=[[0]*(m+1) for _ in range(n+1)]
answer=0

def back(start):
    global answer
    if(start==n*m):
        answer+=1
        return
    
    x=start%m+1
    y=start//m+1
    
    back(start+1)
    
    if board[y-1][x]==0 or board[y][x-1]==0 or board[y-1][x-1]==0:
        board[y][x]=1
        back(start+1)
        board[y][x]=0

back(0)
print(answer)