from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    dot=set()
    for x,y,X,Y in rectangle:
        dot.update([(j+0.5,i) for j in range(y,Y) for i in (x,X)])
        dot.update([(j,i+0.5) for i in range(x,X) for j in (y,Y)])
    
    edge=set()
    for b, a in dot:
        for x,y,X,Y in rectangle:
            if x<a<X and y<b<Y:
                break
        else:
            edge.add((b,a))
    que,dy,dx=deque([(0,characterY,characterX)]),[0.5,0,-0.5,0],[0,0.5,0,-0.5]
    while que:
        cnt,b,a=que.popleft()
        if a==itemX and b==itemY:
            return cnt
        for i in range(4):
            if (b+dy[i],a+dx[i]) in edge:
                edge.remove((b+dy[i],a+dx[i]))
                que.append((cnt+1,b+2*dy[i],a+2*dx[i]))