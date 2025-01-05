import sys
input=sys.stdin.readline

answer=[]

def back(start,pool):
    if len(answer)==6:
        print(" ".join(map(str,answer)))

    for i in range(start,len(pool)):
        answer.append(pool[i])
        back(i+1,pool)
        answer.pop()

while True:
    numbers=list(map(int,input().split()))
    check=numbers[0]
    if check==0:
        break
    pool=numbers[1:]
    back(0,pool)
    answer=[]
    print()