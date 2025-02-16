import sys

input=sys.stdin.readline
N=int(input())
N_list=sorted(list(map(int,input().split())))
M=int(input())
M_list=list(map(int,input().split()))

dic={}

for n in N_list:
    if n in dic:
        dic[n]+=1
    else:
        dic[n]=1

for m in M_list:
    if m in dic:
        print(dic[m],end=' ')
    else:
        print(0,end=' ')