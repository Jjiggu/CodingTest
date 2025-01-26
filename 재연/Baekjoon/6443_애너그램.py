import sys
input=sys.stdin.readline

def back(cnt):
    if cnt==len(word):
        print(*answer)
        return
    
    for i in visited:
        if visited[i]>0:
            visited[i]-=1
            answer.append(i)
            back(cnt+1)
            visited[i]+=1
            answer.pop()            

n=int(input().rstrip())

for j in range(n):
    word=[input().rstrip()]
    word.sort()
    visited={}
    answer=[]
    
    for letter in word:
        if letter in visited:
            visited[letter]+=1
        else:
            visited[letter]=1

    back(0)