n, m = map(int, input().split())

answer=[]

def btk():
    if len(answer)==m:
        print(" ".join(map(str,answer)))
        return
    for i in range(1,n+1):
        if i not in answer:
            answer.append(i)
            btk()
            answer.pop()
btk()



# import itertools

# n, m = map(int, input().split())
# nums = [i for i in range(1, n+1)]

# array = itertools.permutations(nums, m)

# for i in array:
#     for j in i:
#         print(j, end = ' ')
#     print()