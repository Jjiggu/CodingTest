n, m =map(int,input().split())
numbers_list=list(map(int,input().split()))

numbers_set=set(numbers_list)
numbers=list(numbers_set)
numbers.sort()
ans=[]

def back(start):
    if len(ans)==m:
        print(" ".join(map(str,ans)))
        return
    for i in range(start,len(numbers)):
        ans.append(numbers[i])
        back(i)
        ans.pop()
back(0)