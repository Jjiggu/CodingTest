# import sys
# from collections import deque
# input = sys.stdin.readline

# dx=[-1,1,0,0]
# dy=[0,0,-1,1]
# year=0
# n, m = map(int, input().split())
# graph = [list(map(int, input().split())) for _ in range(n)]

# def bfs(x,y):
#     ice=deque([(x,y)])
#     visited[x][y]=1
#     seaList=[]

#     while ice:  
#         x,y=ice.popleft()
#         sea=0
#         for i in range(4):

