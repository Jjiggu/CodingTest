n,m=map(int,input().split())
numbers=list(map(int,input().split()))

numbers.sort()

answer=[]
visited=[0]*n

def back(start):
    if len(answer)==m:
        print(" ".join(map(str,answer)))
        return
    prev=0
    for i in range(start,n):
        if visited[i]==0 and prev!=numbers[i]:
            answer.append(numbers[i])
            visited[i]=1
            prev=numbers[i]
            back(i+1)
            visited[i]=0
            answer.pop()
back(0)