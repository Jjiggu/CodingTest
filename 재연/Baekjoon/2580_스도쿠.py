board=[list(map(int, input().split()))for _ in range(9)]
blank=[]

for i in range(9):
    for j in range(9):
        if board[i][j]==0:
            blank.append([i,j])

def row(n,x):
    for i in range(9):
        if board[x][i]==n:
            return False
    return True

def col(n,y):
    for i in range(9):
        if board[i][y]==n:
            return False
    return True
    
def square(x,y,n):
    x=x//3*3
    y=y//3*3
    for i in range(3):
        for j in range(3):
            if board[x+i][y+j]==n:
                return False
    return True

def back(start):
    if start==len(blank):
        for i in range(9):
            print(*board[i])
        exit()
    x=blank[start][0]
    y=blank[start][1]
    
    for i in range(1,10):
        if col(i,y) and row(i,x) and square(x,y,i):
            board[x][y]=i
            back(start+1)
            board[x][y]=0
back(0)