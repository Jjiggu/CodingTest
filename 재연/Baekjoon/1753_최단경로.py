import sys
import heapq

input=sys.stdin.readline
INF=int(1e9)

def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0

    while q:
        dist, now=heapq.heappop(q)

        if distance[now]<dist:
            continue
            
        for i in graph[now]:
            weight=distance[now]+i[1]
            if weight<distance[i[0]]:
                distance[i[0]]=weight
                heapq.heappush(q,(weight,i[0]))


v,e=map(int,input().split())
k=int(input())

distance=[INF]*(v+1)
graph=[[] for _ in range (v+1)]


for _ in range(e):
    a,b,c,=map(int,input().split())
    graph[a].append((b,c))


dijkstra(k)
for i in range(1,v+1):
     print("INF" if distance[i] == INF else distance[i])
