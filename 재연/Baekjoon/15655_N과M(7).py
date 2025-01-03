n, m=map(int,input().split())
numbers=list(map(int,input().split()))

numbers.sort()
answer=[]

def back():
    if len(answer)==m:
        print(" ".join(map(str,answer)))
        return
    for i in range(n):
        answer.append(numbers[i])
        back()
        answer.pop()
back()