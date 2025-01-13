import sys
input=sys.stdin.readline
students=[input() for _ in range(5)]

dx=(-1,1,0,0)
dy=(0,0,-1,1)

answer=set()
visited=set()

def back(y_cnt):
    global member
    if y_cnt>=4:
        return
    if len(member)==7:
        answer.add(tuple(sorted(member)))
        return
    if tuple(sorted(member)) in visited:
        return
    
    for x,y in member:
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<5 and 0<=ny<5 and (nx,ny) not in member:
                current=y_cnt
                if students[nx][ny]=="Y":
                    current+=1
                member.append((nx,ny))
                back(current)
                member.pop()
    visited.add(tuple(sorted(member)))
    
for i in range(5):
    for j in range(5):
        if students[i][j]=="S":
            member=[(i,j)]
            back(0)
print(len(answer))