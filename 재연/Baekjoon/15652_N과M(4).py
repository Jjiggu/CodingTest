n, m=map(int,input().split())

answer=[]

def back(start):
    if len(answer)==m:
        print(" ".join(map(str,answer)))
        return
    for i in range(start,n+1):
        answer.append(i)
        back(i)
        answer.pop()
back(1)