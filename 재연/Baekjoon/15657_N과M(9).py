n,m=map(int,input().split())
numbers=list(map(int,input().split()))

numbers.sort()

answer=[]
visited=[0]*n

def back():
    if len(answer)==m:
        print(" ".join(map(str,answer)))
        return
    prev=0
    for i in range(n):
        if visited[i]==0 and prev!=numbers[i]:
            answer.append(numbers[i])
            visited[i]=1
            prev=numbers[i]
            back()
            visited[i]=0
            answer.pop()
back()