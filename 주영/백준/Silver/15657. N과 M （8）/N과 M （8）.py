import sys
input = sys.stdin.readline

N, M = map(int,input().split())
LIST = sorted(list(map(int,input().split())))

total = []
def back(s):
    if len(total) == M:
        print(*total)
        return total
    
    for i in range(s,len(LIST)):
        total.append(LIST[i])
        back(i)
        total.pop()


back(0)