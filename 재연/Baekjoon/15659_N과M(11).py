n, m =map(int,input().split())
numbers_list=list(map(int,input().split()))

numbers_set=set(numbers_list)
numbers=list(numbers_set)
numbers.sort()
ans=[]

def back():
    if len(ans)==m:
        print(" ".join(map(str,ans)))
        return
    for i in range(len(numbers)):
        ans.append(numbers[i])
        back()
        ans.pop()
back()