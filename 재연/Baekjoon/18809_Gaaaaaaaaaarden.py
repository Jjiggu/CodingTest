n,m,g,r=map(int,input().split())

garden=[]
flower=[]
answer=0


for i in range(n):
    garden.append([*map(int,input().split())])

# 배양액 뿌리기 가능한 곳 체크
available=[]
for j in range(n):
    for k in range(m):
        if garden[j][k]==2:
            available.append((j,k))

